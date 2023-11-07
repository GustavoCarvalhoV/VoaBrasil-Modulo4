package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelos.Usuarios;

public class UsuarioDAO {

	//create
	public void create(Usuarios usuario) {
		
		String sql = "insert into Usuarios (nome_usuario, sobrenome_usuario, rg_usuario, cpf_usuario, contato_usuario, email_usuario, senha_usuario) values (?, ?, ?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionMySQL.createConnectionMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, usuario.getNome());
			pstm.setString(2, usuario.getSobrenome());
			pstm.setString(3, usuario.getRg());
			pstm.setString(4, usuario.getCpf());
			pstm.setString(5, usuario.getContato());
			pstm.setString(6, usuario.getEmail());
			pstm.setString(7, usuario.getSenha());
			
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
	public List<Usuarios> read() {
		List<Usuarios> usuarios = new ArrayList<Usuarios>();
		String sql = "select * from Usuarios";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			
			conn = ConnectionMySQL.createConnectionMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Usuarios usuario = new Usuarios();
				
				usuario.setId(rset.getInt("id_usuario"));
				usuario.setNome(rset.getString("nome_usuario"));
				usuario.setSobrenome(rset.getString("sobrenome_usuario"));
				usuario.setRg(rset.getString("rg_usuario"));
				usuario.setCpf(rset.getString("cpf_usuario"));
				usuario.setContato(rset.getString("contato_usuario"));
				usuario.setEmail(rset.getString("email_usuario"));
				usuario.setSenha(rset.getString("senha_usuario"));
				
				usuarios.add(usuario);
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
		
		return usuarios;
	}
	
	
	//update
	public void update(Usuarios usuario) {
		String sql = "UPDATE Usuarios SET nome_usuario = ?, sobrenome_usuario = ?, rg_usuario = ?, cpf_usuario = ?, contato_usuario = ?, email_usuario = ?, senha_usuario = ? WHERE id_usuario = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;		
		
		try {
			
			conn = ConnectionMySQL.createConnectionMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, usuario.getNome());
			pstm.setString(2, usuario.getSobrenome());
			pstm.setString(3, usuario.getRg());
			pstm.setString(4, usuario.getCpf());
			pstm.setString(5, usuario.getContato());
			pstm.setString(6, usuario.getEmail());
			pstm.setString(7, usuario.getSenha());
			pstm.setInt(8, usuario.getId());
			
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
		String sql = "DELETE FROM Usuarios Where id_usuario = ?";
		
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
	public Usuarios readById(int id ) {
		Usuarios usuario = new Usuarios();
		String sql = "select * from Usuarios WHERE id_usuario = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			
			conn = ConnectionMySQL.createConnectionMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			rset = pstm.executeQuery();
			
			rset.next();
			
			usuario.setId(rset.getInt("id_usuario"));
			usuario.setNome(rset.getString("nome_usuario"));
			usuario.setSobrenome(rset.getString("sobrenome_usuario"));
			usuario.setRg(rset.getString("rg_usuario"));
			usuario.setCpf(rset.getString("cpf_usuario"));
			usuario.setContato(rset.getString("contato_usuario"));
			usuario.setEmail(rset.getString("email_usuario"));
			usuario.setSenha(rset.getString("senha_usuario"));
			
			
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
	
	
		return usuario;
	}
				
}
