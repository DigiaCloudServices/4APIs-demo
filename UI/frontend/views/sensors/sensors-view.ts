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
  // Set by Router
  location: any;

  static get styles() {
    return [
      CSSModule('lumo-typography'),
      unsafeCSS(styles)
    ];
  }

  @property( { type : Array }  ) readings : SensorData[] = [];
  @property( { type : String }  ) locationId : string = '';

/*   @query('#grid')
  private grid: any;
 */
  render() {
    return html`
      <vaadin-split-layout>
        <div id="editor-layout">
          <iframe style="max-width: 768px; height: 432px; width: 100%; border: none" allow="fullscreen" src="https://showroom.vertex.fi:8443/model-viewer-frame.html?model=8dd961ba-37e2-4bfc-a4af-e4fd67ca0d3d&link=284b0eac-ce7f-4dc0-b170-f52c1bff6746" allowfullscreen></iframe>
          <a href="sensors/2105">2105</a>
          <a href="sensors/3032">3032</a>
          <a href="sensors/3060">3060</a>
        </div>
        <div class="splitLayout__gridTable">
          ${ this.renderGrid() }
        </div>
      </vaadin-split-layout>
    `;
  }

  renderGrid() {
    if (!this.locationId) {
      return html`Select a location`;
    } else if (!this.readings.length) {
      return html`Loading...`
    } else {
      return html`
        <vaadin-grid id="grid" class="splitLayout" theme="no-border" .items=${this.readings}>
          <vaadin-grid-column path="locationId" header="Location"></vaadin-grid-column>
          <vaadin-grid-column path="sensorCategory" header="Category"></vaadin-grid-column>
          <vaadin-grid-column path="sensorAttribute" header="Attribute"></vaadin-grid-column>
          <vaadin-grid-column path="time" header="Time"></vaadin-grid-column>
          <vaadin-grid-column path="value" header="Value"></vaadin-grid-column>
          <vaadin-grid-column path="unit" header="Unit"></vaadin-grid-column>
        </vaadin-grid>      
      `;
    }
  }

  async firstUpdated(changedProperties: any) {
    super.firstUpdated(changedProperties);

    this.locationId = this.location.params.id;

    if (this.locationId) {
      this.readings = await sensorsEndpoint.getSensorReadings(this.locationId);
    }
  }
}
