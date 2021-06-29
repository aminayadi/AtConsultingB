

	package tn.atconsulting.at.apioffice.domain.dto;

	import java.io.Serializable;

	import javax.validation.constraints.NotNull;

	public class DPhoto implements Serializable {
		
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@NotNull
		protected ConnectionDTO connection;
		protected byte [] photo;
		protected String pName;

		

		public String getpName() {
			return pName;
		}
		public void setpName(String pName) {
			this.pName = pName;
		}
		public byte[] getPhoto() {
			return photo;
		}
		public void setPhoto(byte[] photo) {
			this.photo = photo;
		}

		public ConnectionDTO getConnection() {
			return connection;
		}
		public void setConnection(ConnectionDTO connection) {
			this.connection = connection;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		
		
		
		
	}

