import { Component, OnInit } from '@angular/core';
import { MenuItem } from 'primeng/api';

@Component({
  selector: 'app-toolbar',
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.css']
})
export class ToolbarComponent implements OnInit {

  items: MenuItem[];

  ngOnInit() {
    this.fillMenuOptions();
  }

  private fillMenuOptions() {
    this.items = [
      {
        label: 'Firearms',
        items: [
          {
            label: 'Handguns',
            items: [
              { label: 'Revolvers' },
              { label: 'Semi-Automatic' },
              { label: 'Automatic' }
            ]
          },
          {
            label: 'Shotguns',
            items: [
              { label: 'Pump Action' },
              { label: 'Lever Action' },
              { label: 'Single Shot' },
              { label: 'Semi-Automatic' }
            ]
          },
          {
            label: 'Rifles',
            items: [
              { label: 'Semi-Automatic' },
              { label: 'Bolt Action' },
              { label: 'Lever Action' }
            ]
          }
        ]
      },

      {
        label: 'Ammo',
        items: [
          { label: 'Handgun' },
          { label: 'Shotgun' },
          { label: 'Rifle' },
          { label: 'Bulk Ammo' },
          { label: 'Blanks' }
        ]
      },

      {
        label: 'Optics',
        items: [
          { label: 'Binoculars' },
          { label: 'Flashlights' },
          { label: 'Night Vision' },
          { label: 'Rangefinder' },
          { label: 'Scope Mounts' },
          { label: 'Scopes' },
          { label: 'Lasers' },
          { label: 'Sights' },
          { label: 'Spotting Scopes' },
          { label: 'Thermal Optics' }
        ]
      },

      {
        label: 'Knives',
        items: [
          { label: 'Fixed Blade' },
          { label: 'Folding Blade' },
          { label: 'Accessories' },
          { label: 'Utility' }
        ]
      },

      {
        label: 'Suppressors',
        items: [
          { label: 'Handguns' },
          { label: 'Rifles' }
        ]
      }
    ];
  }
}
