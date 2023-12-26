import React, { Component } from 'react'
import GovSteam1Service from '../services/GovSteam1Service'

class ListGovSteam1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
                govSteam1s: []
        }
        this.addGovSteam1 = this.addGovSteam1.bind(this);
        this.editGovSteam1 = this.editGovSteam1.bind(this);
        this.deleteGovSteam1 = this.deleteGovSteam1.bind(this);
    }

    deleteGovSteam1(id){
        GovSteam1Service.deleteGovSteam1(id).then( res => {
            this.setState({govSteam1s: this.state.govSteam1s.filter(govSteam1 => govSteam1.govSteam1Id !== id)});
        });
    }
    viewGovSteam1(id){
        this.props.history.push(`/view-govSteam1/${id}`);
    }
    editGovSteam1(id){
        this.props.history.push(`/add-govSteam1/${id}`);
    }

    componentDidMount(){
        GovSteam1Service.getGovSteam1s().then((res) => {
            this.setState({ govSteam1s: res.data});
        });
    }

    addGovSteam1(){
        this.props.history.push('/add-govSteam1/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">GovSteam1 List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addGovSteam1}> Add GovSteam1</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Db1 </th>
                                    <th> Db2 </th>
                                    <th> Eps </th>
                                    <th> Gv1 </th>
                                    <th> Gv2 </th>
                                    <th> Gv3 </th>
                                    <th> Gv4 </th>
                                    <th> Gv5 </th>
                                    <th> Gv6 </th>
                                    <th> K </th>
                                    <th> K1 </th>
                                    <th> K2 </th>
                                    <th> K3 </th>
                                    <th> K4 </th>
                                    <th> K5 </th>
                                    <th> K6 </th>
                                    <th> K7 </th>
                                    <th> K8 </th>
                                    <th> Mwbase </th>
                                    <th> Pgv1 </th>
                                    <th> Pgv2 </th>
                                    <th> Pgv3 </th>
                                    <th> Pgv4 </th>
                                    <th> Pgv5 </th>
                                    <th> Pgv6 </th>
                                    <th> Pmax </th>
                                    <th> Pmin </th>
                                    <th> Sdb1 </th>
                                    <th> Sdb2 </th>
                                    <th> T1 </th>
                                    <th> T2 </th>
                                    <th> T3 </th>
                                    <th> T4 </th>
                                    <th> T5 </th>
                                    <th> T6 </th>
                                    <th> T7 </th>
                                    <th> Uc </th>
                                    <th> Uo </th>
                                    <th> Valve </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.govSteam1s.map(
                                        govSteam1 => 
                                        <tr key = {govSteam1.govSteam1Id}>
                                             <td> { govSteam1.db1 } </td>
                                             <td> { govSteam1.db2 } </td>
                                             <td> { govSteam1.eps } </td>
                                             <td> { govSteam1.gv1 } </td>
                                             <td> { govSteam1.gv2 } </td>
                                             <td> { govSteam1.gv3 } </td>
                                             <td> { govSteam1.gv4 } </td>
                                             <td> { govSteam1.gv5 } </td>
                                             <td> { govSteam1.gv6 } </td>
                                             <td> { govSteam1.k } </td>
                                             <td> { govSteam1.k1 } </td>
                                             <td> { govSteam1.k2 } </td>
                                             <td> { govSteam1.k3 } </td>
                                             <td> { govSteam1.k4 } </td>
                                             <td> { govSteam1.k5 } </td>
                                             <td> { govSteam1.k6 } </td>
                                             <td> { govSteam1.k7 } </td>
                                             <td> { govSteam1.k8 } </td>
                                             <td> { govSteam1.mwbase } </td>
                                             <td> { govSteam1.pgv1 } </td>
                                             <td> { govSteam1.pgv2 } </td>
                                             <td> { govSteam1.pgv3 } </td>
                                             <td> { govSteam1.pgv4 } </td>
                                             <td> { govSteam1.pgv5 } </td>
                                             <td> { govSteam1.pgv6 } </td>
                                             <td> { govSteam1.pmax } </td>
                                             <td> { govSteam1.pmin } </td>
                                             <td> { govSteam1.sdb1 } </td>
                                             <td> { govSteam1.sdb2 } </td>
                                             <td> { govSteam1.t1 } </td>
                                             <td> { govSteam1.t2 } </td>
                                             <td> { govSteam1.t3 } </td>
                                             <td> { govSteam1.t4 } </td>
                                             <td> { govSteam1.t5 } </td>
                                             <td> { govSteam1.t6 } </td>
                                             <td> { govSteam1.t7 } </td>
                                             <td> { govSteam1.uc } </td>
                                             <td> { govSteam1.uo } </td>
                                             <td> { govSteam1.valve } </td>
                                             <td>
                                                 <button onClick={ () => this.editGovSteam1(govSteam1.govSteam1Id)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteGovSteam1(govSteam1.govSteam1Id)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewGovSteam1(govSteam1.govSteam1Id)} className="btn btn-info btn-sm">View </button>
                                             </td>
                                        </tr>
                                    )
                                }
                            </tbody>
                        </table>

                 </div>

            </div>
        )
    }
}

export default ListGovSteam1Component
