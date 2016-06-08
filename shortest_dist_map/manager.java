/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Daniel
 */
public class manager {
    private String m_name;
    private String m_pass;
    private String m_role;

    public manager(String m_name, String m_pass, String m_role) {
        this.m_name = m_name;
        this.m_pass = m_pass;
        this.m_role = m_role;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public void setM_pass(String m_pass) {
        this.m_pass = m_pass;
    }

    public void setM_role(String m_role) {
        this.m_role = m_role;
    }

    public String getM_name() {
        return m_name;
    }

    public String getM_pass() {
        return m_pass;
    }

    public String getM_role() {
        return m_role;
    }
    
   // to print out and save a manager profile
    @Override
    public String toString() {
        return "manager{" + "m_name= " + m_name + " ,m_pass= " + m_pass + " ,m_role=" + m_role + '}';
    }
}
