import React, { Component } from 'react'
import GovGAST1Service from '../services/GovGAST1Service'

class ListGovGAST1Component extends Component {
    constructor(props) {
        super(props)

        this.state = {
                govGAST1s: []
        }
        this.addGovGAST1 = this.addGovGAST1.bind(this);
        this.editGovGAST1 = this.editGovGAST1.bind(this);
        this.deleteGovGAST1 = this.deleteGovGAST1.bind(this);
    }

    deleteGovGAST1(id){
        GovGAST1Service.deleteGovGAST1(id).then( res => {
            this.setState({govGAST1s: this.state.govGAST1s.filter(govGAST1 => govGAST1.govGAST1Id !== id)});
        });
    }
    viewGovGAST1(id){
        this.props.history.push(`/view-govGAST1/${id}`);
    }
    editGovGAST1(id){
        this.props.history.push(`/add-govGAST1/${id}`);
    }

    componentDidMount(){
        GovGAST1Service.getGovGAST1s().then((res) => {
            this.setState({ govGAST1s: res.data});
        });
    }

    addGovGAST1(){
        this.props.history.push('/add-govGAST1/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">GovGAST1 List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addGovGAST1}> Add GovGAST1</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> A </th>
                                    <th> B </th>
                                    <th> Db1 </th>
                                    <th> Db2 </th>
                                    <th> Eps </th>
                                    <th> Fidle </th>
                                    <th> Gv1 </th>
                                    <th> Gv2 </th>
                                    <th> Gv3 </th>
                                    <th> Gv4 </th>
                                    <th> Gv5 </th>
                                    <th> Gv6 </th>
                                    <th> Ka </th>
                                    <th> Kt </th>
                                    <th> Lmax </th>
                                    <th> Loadinc </th>
                                    <th> Ltrate </th>
                                    <th> Mwbase </th>
                                    <th> Pgv1 </th>
                                    <th> Pgv2 </th>
                                    <th> Pgv3 </th>
                                    <th> Pgv4 </th>
                                    <th> Pgv5 </th>
                                    <th> Pgv6 </th>
                                    <th> R </th>
                                    <th> Rmax </th>
                                    <th> T1 </th>
                                    <th> T2 </th>
                                    <th> T3 </th>
                                    <th> T4 </th>
                                    <th> T5 </th>
                                    <th> Tltr </th>
                                    <th> Vmax </th>
                                    <th> Vmin </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.govGAST1s.map(
                                        govGAST1 => 
                                        <tr key = {govGAST1.govGAST1Id}>
                                             <td> { govGAST1.a } </td>
                                             <td> { govGAST1.b } </td>
                                             <td> { govGAST1.db1 } </td>
                                             <td> { govGAST1.db2 } </td>
                                             <td> { govGAST1.eps } </td>
                                             <td> { govGAST1.fidle } </td>
                                             <td> { govGAST1.gv1 } </td>
                                             <td> { govGAST1.gv2 } </td>
                                             <td> { govGAST1.gv3 } </td>
                                             <td> { govGAST1.gv4 } </td>
                                             <td> { govGAST1.gv5 } </td>
                                             <td> { govGAST1.gv6 } </td>
                                             <td> { govGAST1.ka } </td>
                                             <td> { govGAST1.kt } </td>
                                             <td> { govGAST1.lmax } </td>
                                             <td> { govGAST1.loadinc } </td>
                                             <td> { govGAST1.ltrate } </td>
                                             <td> { govGAST1.mwbase } </td>
                                             <td> { govGAST1.pgv1 } </td>
                                             <td> { govGAST1.pgv2 } </td>
                                             <td> { govGAST1.pgv3 } </td>
                                             <td> { govGAST1.pgv4 } </td>
                                             <td> { govGAST1.pgv5 } </td>
                                             <td> { govGAST1.pgv6 } </td>
                                             <td> { govGAST1.r } </td>
                                             <td> { govGAST1.rmax } </td>
                                             <td> { govGAST1.t1 } </td>
                                             <td> { govGAST1.t2 } </td>
                                             <td> { govGAST1.t3 } </td>
                                             <td> { govGAST1.t4 } </td>
                                             <td> { govGAST1.t5 } </td>
                                             <td> { govGAST1.tltr } </td>
                                             <td> { govGAST1.vmax } </td>
                                             <td> { govGAST1.vmin } </td>
                                             <td>
                                                 <button onClick={ () => this.editGovGAST1(govGAST1.govGAST1Id)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteGovGAST1(govGAST1.govGAST1Id)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewGovGAST1(govGAST1.govGAST1Id)} className="btn btn-info btn-sm">View </button>
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

export default ListGovGAST1Component
