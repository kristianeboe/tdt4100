package objectstructures;

public class Partner {
	
	private String name;
	private Partner partner;
	
	public Partner(String name){
		this.name = name;
		this.partner = null;
	}

	public String getName() {
		return name;
	}

	public Partner getPartner() {
		return partner;
	}
	
	public void setPartner(Partner partner1){
		if(partner1 == null && this.partner != null){
			this.partner.setSingle();
			this.partner = null;
		} else if(this.partner == null && partner1 != null){
			this.partner = partner1;
			partner1.setPartner(this);
		} else if(this.partner != partner1){
			this.partner.setSingle();
			this.partner = partner1;
			partner1.setPartner(this);
		}
	}
	
	public void setSingle(){
		this.partner = null;
	}
	
	public String toString(){
		if(this.getPartner() == null){
			return this.getName() + " er singel";
		}
		return this.getName() +" - " + this.partner.getName();
	}
	
	public static void main(String[] args) {
		Partner kristian = new Partner("Kristian");
		Partner nicolaj = new Partner("Nicolaj");
		Partner JA = new Partner("Jessica Alba");
		Partner PT = new Partner("Phobe Tonkin");
		
		kristian.setPartner(JA);
		System.out.println(kristian);
		kristian.setPartner(null);
		System.out.println(kristian);
		System.out.println(JA);

		nicolaj.setPartner(PT);
		nicolaj.setPartner(kristian);
		
		JA.setPartner(PT);
		
		System.out.println(kristian);
		System.out.println(nicolaj);
		System.out.println(JA);
		System.out.println(PT);
		
	}
}
