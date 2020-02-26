import {Router} from '@vaadin/router';

import './global-styles';
import './main-layout';

import './views/sensors/sensors-view';

const routes = [
  {
    path: '',
    component: 'main-layout',
    children: [
      { path: '', component: 'sensors-view' },
      { path: 'sensors/:id?', component: 'sensors-view' },
    ]
  }
];

const router = new Router(document.querySelector('#outlet'));
router.setRoutes(routes);
