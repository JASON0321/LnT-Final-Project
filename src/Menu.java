public class Menu {
	
	private String kodeMenu, namaMenu; 
	private int hargaMenu, stokMenu;

	public Menu() {
		// TODO Auto-generated constructor stub
	}
	
	public Menu(String kodeMenu, String namaMenu, int hargaMenu, int stokMenu) {
		super();
		this.kodeMenu = kodeMenu;
		this.namaMenu = namaMenu;
		this.hargaMenu = hargaMenu;
		this.stokMenu = stokMenu;
	}

	public String getKodeMenu() {
		return kodeMenu;
	}

	public void setKodeMenu(String kodeMenu) {
		this.kodeMenu = kodeMenu;
	}

	public String getNamaMenu() {
		return namaMenu;
	}

	public void setNamaMenu(String namaMenu) {
		this.namaMenu = namaMenu;
	}

	public int getHargaMenu() {
		return hargaMenu;
	}

	public void setHargaMenu(int hargaMenu) {
		this.hargaMenu = hargaMenu;
	}

	public int getStokMenu() {
		return stokMenu;
	}

	public void setStokMenu(int stokMenu) {
		this.stokMenu = stokMenu;
	}

}
