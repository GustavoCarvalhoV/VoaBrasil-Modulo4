package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelos.Destinos;

public class DestinoDAO {
	
	//create
		public void create(Destinos destino) {
			
			String sql = "insert into Destinos (cidade_destino, estado_destino) values (?, ?)";
			
			Connection conn = null;
			PreparedStatement pstm = null;
			
			try {
				conn = ConnectionMySQL.createConnectionMySQL();
				
				pstm = conn.prepareStatement(sql);
				
				pstm.setString(1, destino.getCidade());
				pstm.setString(2, destino.getEstado());
				
				pstm.execute();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (pstm != null) {
						pstm.close();
					}
					if (conn != null) {
						conn.close();
					} 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}
		
		
		//read
		public List<Destinos> read() {
			List<Destinos> Destinos = new ArrayList<Destinos>();
			String sql = "select * from Destinos";
			
			Connection conn = null;
			PreparedStatement pstm = null;
			ResultSet rset = null;
			
			try {
				
				conn = ConnectionMySQL.createConnectionMySQL();
				
				pstm = conn.prepareStatement(sql);
				
				rset = pstm.executeQuery();
				
				while (rset.next()) {
					Destinos destino = new Destinos();
					
					destino.setId(rset.getInt("id_destino"));
					destino.setCidade(rset.getString("cidade_destino"));
					destino.setEstado(rset.getString("estado_destino"));
					
					Destinos.add(destino);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (pstm != null) {
						pstm.close();
					}
					if (conn != null) {
						conn.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			return Destinos;
		}
		
		
		//update
		public void update(Destinos destino) {
			String sql = "UPDATE Destinos SET cidade_destino = ?, estado_destino = ? WHERE id_destino = ?";
			
			Connection conn = null;
			PreparedStatement pstm = null;		
			
			try {
				
				conn = ConnectionMySQL.createConnectionMySQL();
				
				pstm = conn.prepareStatement(sql);
				
				pstm.setString(1, destino.getCidade());
				pstm.setString(2, destino.getEstado());			
				pstm.setInt(3, destino.getId());
				
				pstm.execute();
																				
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (pstm != null) {
						pstm.close();
					}
					if (conn != null) {
						conn.close();
					} 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		
		}
		
		//delete
		public void delete(int id) {
			String sql = "DELETE FROM Destinos WHERE id_destino = ?";
			
			Connection conn = null;
			PreparedStatement pstm = null;
				
			try {
					
				conn = ConnectionMySQL.createConnectionMySQL();
					
				pstm = conn.prepareStatement(sql);
					
				pstm.setInt(1,id);
				
				pstm.execute();
					
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (pstm != null) {
						pstm.close();
					}
					if (conn != null) {
						conn.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		//readById
		public Destinos readById(int id ) {
			Destinos destino = new Destinos();
			String sql = "select * from Destinos WHERE id_destino = ?";
			
			Connection conn = null;
			PreparedStatement pstm = null;
			ResultSet rset = null;
			
			try {
				
				conn = ConnectionMySQL.createConnectionMySQL();
				
				pstm = conn.prepareStatement(sql);
				
				pstm.setInt(1, id);
				
				rset = pstm.executeQuery();
				
				rset.next();
				
				destino.setId(rset.getInt("id_destino"));
				destino.setCidade(rset.getString("cidade_destino"));
				destino.setEstado(rset.getString("estado_destino"));
				
					
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (pstm != null) {
						pstm.close();
					}
					if (conn != null) {
						conn.close();
					} 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		
		
			return destino;
		}
		

}
