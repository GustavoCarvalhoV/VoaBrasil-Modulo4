package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelos.Destinos;
import modelos.Passagens;
import modelos.Usuarios;

public class PassagemDAO {

	//create
			public void create(Passagens passagem) {
				
				String sql = "insert into Passagens (id_usuario, id_destino, preco_passagem, horario_passagem, data_ida_passagem, data_volta_passagem) values (?, ?, ?, ?, ?, ?)";
				
				Connection conn = null;
				PreparedStatement pstm = null;
				
				try {
					conn = ConnectionMySQL.createConnectionMySQL();
					
					pstm = conn.prepareStatement(sql);
					
					pstm.setInt(1, passagem.getUsuario().getId());					
					pstm.setInt(2, passagem.getDestino().getId());					
					pstm.setFloat(3, passagem.getPreco());
					pstm.setString(4, passagem.getHorario());
					pstm.setString(5, passagem.getDataIda());
					pstm.setString(6, passagem.getDataVolta());
					
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
			public List<Passagens> read() {
				List<Passagens> Passagens = new ArrayList<Passagens>();
				String sql = "select * from passagens";
				
				Connection conn = null;
				PreparedStatement pstm = null;
				ResultSet rset = null;
				
				try {
					
					conn = ConnectionMySQL.createConnectionMySQL();
					
					pstm = conn.prepareStatement(sql);
					
					rset = pstm.executeQuery();
					
					while (rset.next()) {
						Passagens passagem = new Passagens();
													
						passagem.setId(rset.getInt("id_passagem"));					
						passagem.setPreco(rset.getFloat("preco_passagem"));
						passagem.setHorario(rset.getString("horario_passagem"));
						passagem.setDataIda(rset.getString("data_ida_passagem"));
						passagem.setDataVolta(rset.getString("data_volta_passagem"));
						
						int idUsuario = rset.getInt("id_usuario");
						UsuarioDAO usuarioDAO = new UsuarioDAO();
						Usuarios usuario = usuarioDAO.readById(idUsuario);
						
						int idDestino = rset.getInt("id_destino");
						DestinoDAO destinoDAO = new DestinoDAO();
						Destinos destino = destinoDAO.readById(idDestino);
																							
						passagem.setDestino(destino);
						passagem.setUsuario(usuario);
						
						Passagens.add(passagem);
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
				
				return Passagens;
			}
			
			
			//update
			public void update(Passagens passagem) {
				String sql = "UPDATE Passagens SET id_usuario = ?, id_destino = ?, preco_passagem = ?, horario_passagem = ?, data_ida_passagem = ?, data_volta_passagem = ? Where id_passagem = ?";
				
				Connection conn = null;
				PreparedStatement pstm = null;		
				
				try {
					
					conn = ConnectionMySQL.createConnectionMySQL();
					
					pstm = conn.prepareStatement(sql);
					
					pstm.setInt(1, passagem.getUsuario().getId());					
					pstm.setInt(2, passagem.getDestino().getId());					
					pstm.setFloat(3, passagem.getPreco());
					pstm.setString(4, passagem.getHorario());
					pstm.setString(5, passagem.getDataIda());
					pstm.setString(6, passagem.getDataVolta());
					pstm.setInt(7, passagem.getId());
					
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
				String sql = "DELETE FROM Passagens WHERE id_passagem = ?";
				
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
			public Passagens readById(int id ) {			
				Passagens passagem = new Passagens();
				String sql = "select * from Passagens WHERE id_passagem = ?";
				
				Connection conn = null;
				PreparedStatement pstm = null;
				ResultSet rset = null;
				
				try {
					
					conn = ConnectionMySQL.createConnectionMySQL();
					
					pstm = conn.prepareStatement(sql);
					
					pstm.setInt(1, id);
					
					rset = pstm.executeQuery();
					
					rset.next();
					
											
					passagem.setId(rset.getInt("id_passagem"));					
					passagem.setPreco(rset.getFloat("preco_passagem"));
					passagem.setHorario(rset.getString("horario_passagem"));
					passagem.setDataIda(rset.getString("data_ida_passagem"));
					passagem.setDataVolta(rset.getString("data_volta_passagem"));
					
					int idUsuario = rset.getInt("id_usuario");
					UsuarioDAO usuarioDAO = new UsuarioDAO();
					Usuarios usuario = usuarioDAO.readById(idUsuario);
					
					int idDestino = rset.getInt("id_destino");
					DestinoDAO destinoDAO = new DestinoDAO();
					Destinos destino = destinoDAO.readById(idDestino);
					
					passagem.setDestino(destino);
					passagem.setUsuario(usuario);
					
						
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
			
			
				return passagem;
			}
}
