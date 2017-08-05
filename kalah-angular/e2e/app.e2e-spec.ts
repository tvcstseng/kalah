import { KalahAngularPage } from './app.po';

describe('kalah-angular App', () => {
  let page: KalahAngularPage;

  beforeEach(() => {
    page = new KalahAngularPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
