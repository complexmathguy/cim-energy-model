import React, { Component } from 'react'
import GovHydroFrancisService from '../services/GovHydroFrancisService'

class ListGovHydroFrancisComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                govHydroFranciss: []
        }
        this.addGovHydroFrancis = this.addGovHydroFrancis.bind(this);
        this.editGovHydroFrancis = this.editGovHydroFrancis.bind(this);
        this.deleteGovHydroFrancis = this.deleteGovHydroFrancis.bind(this);
    }

    deleteGovHydroFrancis(id){
        GovHydroFrancisService.deleteGovHydroFrancis(id).then( res => {
            this.setState({govHydroFranciss: this.state.govHydroFranciss.filter(govHydroFrancis => govHydroFrancis.govHydroFrancisId !== id)});
        });
    }
    viewGovHydroFrancis(id){
        this.props.history.push(`/view-govHydroFrancis/${id}`);
    }
    editGovHydroFrancis(id){
        this.props.history.push(`/add-govHydroFrancis/${id}`);
    }

    componentDidMount(){
        GovHydroFrancisService.getGovHydroFranciss().then((res) => {
            this.setState({ govHydroFranciss: res.data});
        });
    }

    addGovHydroFrancis(){
        this.props.history.push('/add-govHydroFrancis/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">GovHydroFrancis List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addGovHydroFrancis}> Add GovHydroFrancis</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Am </th>
                                    <th> Av0 </th>
                                    <th> Av1 </th>
                                    <th> Bp </th>
                                    <th> Db1 </th>
                                    <th> Etamax </th>
                                    <th> GovernorControl </th>
                                    <th> H1 </th>
                                    <th> H2 </th>
                                    <th> Hn </th>
                                    <th> Kc </th>
                                    <th> Kg </th>
                                    <th> Kt </th>
                                    <th> Qc0 </th>
                                    <th> Qn </th>
                                    <th> Ta </th>
                                    <th> Td </th>
                                    <th> Ts </th>
                                    <th> Twnc </th>
                                    <th> Twng </th>
                                    <th> Tx </th>
                                    <th> Va </th>
                                    <th> Valvmax </th>
                                    <th> Valvmin </th>
                                    <th> Vc </th>
                                    <th> WaterTunnelSurgeChamberSimulation </th>
                                    <th> Zsfc </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.govHydroFranciss.map(
                                        govHydroFrancis => 
                                        <tr key = {govHydroFrancis.govHydroFrancisId}>
                                             <td> { govHydroFrancis.am } </td>
                                             <td> { govHydroFrancis.av0 } </td>
                                             <td> { govHydroFrancis.av1 } </td>
                                             <td> { govHydroFrancis.bp } </td>
                                             <td> { govHydroFrancis.db1 } </td>
                                             <td> { govHydroFrancis.etamax } </td>
                                             <td> { govHydroFrancis.governorControl } </td>
                                             <td> { govHydroFrancis.h1 } </td>
                                             <td> { govHydroFrancis.h2 } </td>
                                             <td> { govHydroFrancis.hn } </td>
                                             <td> { govHydroFrancis.kc } </td>
                                             <td> { govHydroFrancis.kg } </td>
                                             <td> { govHydroFrancis.kt } </td>
                                             <td> { govHydroFrancis.qc0 } </td>
                                             <td> { govHydroFrancis.qn } </td>
                                             <td> { govHydroFrancis.ta } </td>
                                             <td> { govHydroFrancis.td } </td>
                                             <td> { govHydroFrancis.ts } </td>
                                             <td> { govHydroFrancis.twnc } </td>
                                             <td> { govHydroFrancis.twng } </td>
                                             <td> { govHydroFrancis.tx } </td>
                                             <td> { govHydroFrancis.va } </td>
                                             <td> { govHydroFrancis.valvmax } </td>
                                             <td> { govHydroFrancis.valvmin } </td>
                                             <td> { govHydroFrancis.vc } </td>
                                             <td> { govHydroFrancis.waterTunnelSurgeChamberSimulation } </td>
                                             <td> { govHydroFrancis.zsfc } </td>
                                             <td>
                                                 <button onClick={ () => this.editGovHydroFrancis(govHydroFrancis.govHydroFrancisId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteGovHydroFrancis(govHydroFrancis.govHydroFrancisId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewGovHydroFrancis(govHydroFrancis.govHydroFrancisId)} className="btn btn-info btn-sm">View </button>
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

export default ListGovHydroFrancisComponent
