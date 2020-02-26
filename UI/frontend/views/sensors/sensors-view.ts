import { customElement, html, LitElement, unsafeCSS, property } from 'lit-element';

import '@vaadin/vaadin-grid/vaadin-grid';
import '@vaadin/vaadin-grid/vaadin-grid-column';
import '@vaadin/vaadin-ordered-layout/vaadin-horizontal-layout';
import '@vaadin/vaadin-split-layout/vaadin-split-layout';
import '@vaadin/vaadin-text-field/vaadin-text-field';

// utilities to import style modules
import { CSSModule } from '../../css-utils';

// @ts-ignore
import styles from './sensors.css';


import * as sensorsEndpoint from '../../generated/Sensors';
import SensorData from '../../generated/com/example/application/backend/SensorData';

@customElement('sensors-view')
export class SensorsViewElement extends LitElement {
  // Set by Rotuer
  location: any;

  static get styles() {
    return [
      CSSModule('lumo-typography'),
      unsafeCSS(styles)
    ];
  }

  @property( { type : Array }  ) readings : SensorData[] = [];

/*   @query('#grid')
  private grid: any;
 */
  render() {
    return html`
      <vaadin-split-layout>
        <div id="editor-layout">
          <img src="ypsilon.png">
          <a href="sensors/">All</a>
          <a href="sensors/2105">2105</a>
          <a href="sensors/2321">2321</a>
        </div>
        <div class="splitLayout__gridTable">
          <vaadin-grid id="grid" class="splitLayout" theme="no-border" .items=${this.readings}>
            <vaadin-grid-column path="locationId" header="Location"></vaadin-grid-column>
            <vaadin-grid-column path="sensorCategory" header="Category"></vaadin-grid-column>
            <vaadin-grid-column path="sensorAttribute" header="Attribute"></vaadin-grid-column>
            <vaadin-grid-column path="time" header="Time"></vaadin-grid-column>
            <vaadin-grid-column path="value" header="Value"></vaadin-grid-column>
            <vaadin-grid-column path="unit" header="Unit"></vaadin-grid-column>
          </vaadin-grid>
        </div>
      </vaadin-split-layout>
    `;
  }

  async firstUpdated(changedProperties: any) {
    super.firstUpdated(changedProperties);

    let locationId = this.location.params.id;

    this.readings = await sensorsEndpoint.getSensorReadings(locationId);
  }
}
