import { Component, OnInit } from '@angular/core';

import { MenuItem } from 'primeng/api';

@Component({
  selector: 'app-breadcrumb',
  templateUrl: './breadcrumb.component.html',
  styleUrls: ['./breadcrumb.component.css']
})
export class BreadcrumbComponent implements OnInit {

  homeMenuItem: MenuItem;
  menuItems: MenuItem[];

  ngOnInit(): void {
    this.homeMenuItem = { icon: 'pi pi-home' };

    // TODO: fill the array with information from the actual URL
    this.menuItems = [
      { label: 'Firearms' },
      { label: 'Rifles' }
    ];
  }
}
