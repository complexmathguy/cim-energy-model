import React, { Component } from 'react'
import GovHydroRService from '../services/GovHydroRService'

class ListGovHydroRComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                govHydroRs: []
        }
        this.addGovHydroR = this.addGovHydroR.bind(this);
        this.editGovHydroR = this.editGovHydroR.bind(this);
        this.deleteGovHydroR = this.deleteGovHydroR.bind(this);
    }

    deleteGovHydroR(id){
        GovHydroRService.deleteGovHydroR(id).then( res => {
            this.setState({govHydroRs: this.state.govHydroRs.filter(govHydroR => govHydroR.govHydroRId !== id)});
        });
    }
    viewGovHydroR(id){
        this.props.history.push(`/view-govHydroR/${id}`);
    }
    editGovHydroR(id){
        this.props.history.push(`/add-govHydroR/${id}`);
    }

    componentDidMount(){
        GovHydroRService.getGovHydroRs().then((res) => {
            this.setState({ govHydroRs: res.data});
        });
    }

    addGovHydroR(){
        this.props.history.push('/add-govHydroR/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">GovHydroR List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addGovHydroR}> Add GovHydroR</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> At </th>
                                    <th> Db1 </th>
                                    <th> Db2 </th>
                                    <th> Dturb </th>
                                    <th> Eps </th>
                                    <th> Gmax </th>
                                    <th> Gmin </th>
                                    <th> Gv1 </th>
                                    <th> Gv2 </th>
                                    <th> Gv3 </th>
                                    <th> Gv4 </th>
                                    <th> Gv5 </th>
                                    <th> Gv6 </th>
                                    <th> H0 </th>
                                    <th> InputSignal </th>
                                    <th> Kg </th>
                                    <th> Ki </th>
                                    <th> Mwbase </th>
                                    <th> Pgv1 </th>
                                    <th> Pgv2 </th>
                                    <th> Pgv3 </th>
                                    <th> Pgv4 </th>
                                    <th> Pgv5 </th>
                                    <th> Pgv6 </th>
                                    <th> Pmax </th>
                                    <th> Pmin </th>
                                    <th> Qnl </th>
                                    <th> R </th>
                                    <th> T1 </th>
                                    <th> T2 </th>
                                    <th> T3 </th>
                                    <th> T4 </th>
                                    <th> T5 </th>
                                    <th> T6 </th>
                                    <th> T7 </th>
                                    <th> T8 </th>
                                    <th> Td </th>
                                    <th> Tp </th>
                                    <th> Tt </th>
                                    <th> Tw </th>
                                    <th> Velcl </th>
                                    <th> Velop </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.govHydroRs.map(
                                        govHydroR => 
                                        <tr key = {govHydroR.govHydroRId}>
                                             <td> { govHydroR.at } </td>
                                             <td> { govHydroR.db1 } </td>
                                             <td> { govHydroR.db2 } </td>
                                             <td> { govHydroR.dturb } </td>
                                             <td> { govHydroR.eps } </td>
                                             <td> { govHydroR.gmax } </td>
                                             <td> { govHydroR.gmin } </td>
                                             <td> { govHydroR.gv1 } </td>
                                             <td> { govHydroR.gv2 } </td>
                                             <td> { govHydroR.gv3 } </td>
                                             <td> { govHydroR.gv4 } </td>
                                             <td> { govHydroR.gv5 } </td>
                                             <td> { govHydroR.gv6 } </td>
                                             <td> { govHydroR.h0 } </td>
                                             <td> { govHydroR.inputSignal } </td>
                                             <td> { govHydroR.kg } </td>
                                             <td> { govHydroR.ki } </td>
                                             <td> { govHydroR.mwbase } </td>
                                             <td> { govHydroR.pgv1 } </td>
                                             <td> { govHydroR.pgv2 } </td>
                                             <td> { govHydroR.pgv3 } </td>
                                             <td> { govHydroR.pgv4 } </td>
                                             <td> { govHydroR.pgv5 } </td>
                                             <td> { govHydroR.pgv6 } </td>
                                             <td> { govHydroR.pmax } </td>
                                             <td> { govHydroR.pmin } </td>
                                             <td> { govHydroR.qnl } </td>
                                             <td> { govHydroR.r } </td>
                                             <td> { govHydroR.t1 } </td>
                                             <td> { govHydroR.t2 } </td>
                                             <td> { govHydroR.t3 } </td>
                                             <td> { govHydroR.t4 } </td>
                                             <td> { govHydroR.t5 } </td>
                                             <td> { govHydroR.t6 } </td>
                                             <td> { govHydroR.t7 } </td>
                                             <td> { govHydroR.t8 } </td>
                                             <td> { govHydroR.td } </td>
                                             <td> { govHydroR.tp } </td>
                                             <td> { govHydroR.tt } </td>
                                             <td> { govHydroR.tw } </td>
                                             <td> { govHydroR.velcl } </td>
                                             <td> { govHydroR.velop } </td>
                                             <td>
                                                 <button onClick={ () => this.editGovHydroR(govHydroR.govHydroRId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteGovHydroR(govHydroR.govHydroRId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewGovHydroR(govHydroR.govHydroRId)} className="btn btn-info btn-sm">View </button>
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

export default ListGovHydroRComponent
