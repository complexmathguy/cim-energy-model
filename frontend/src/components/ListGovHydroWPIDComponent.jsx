import React, { Component } from 'react'
import GovHydroWPIDService from '../services/GovHydroWPIDService'

class ListGovHydroWPIDComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                govHydroWPIDs: []
        }
        this.addGovHydroWPID = this.addGovHydroWPID.bind(this);
        this.editGovHydroWPID = this.editGovHydroWPID.bind(this);
        this.deleteGovHydroWPID = this.deleteGovHydroWPID.bind(this);
    }

    deleteGovHydroWPID(id){
        GovHydroWPIDService.deleteGovHydroWPID(id).then( res => {
            this.setState({govHydroWPIDs: this.state.govHydroWPIDs.filter(govHydroWPID => govHydroWPID.govHydroWPIDId !== id)});
        });
    }
    viewGovHydroWPID(id){
        this.props.history.push(`/view-govHydroWPID/${id}`);
    }
    editGovHydroWPID(id){
        this.props.history.push(`/add-govHydroWPID/${id}`);
    }

    componentDidMount(){
        GovHydroWPIDService.getGovHydroWPIDs().then((res) => {
            this.setState({ govHydroWPIDs: res.data});
        });
    }

    addGovHydroWPID(){
        this.props.history.push('/add-govHydroWPID/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">GovHydroWPID List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addGovHydroWPID}> Add GovHydroWPID</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> D </th>
                                    <th> Gatmax </th>
                                    <th> Gatmin </th>
                                    <th> Gv1 </th>
                                    <th> Gv2 </th>
                                    <th> Gv3 </th>
                                    <th> Kd </th>
                                    <th> Ki </th>
                                    <th> Kp </th>
                                    <th> Mwbase </th>
                                    <th> Pgv1 </th>
                                    <th> Pgv2 </th>
                                    <th> Pgv3 </th>
                                    <th> Pmax </th>
                                    <th> Pmin </th>
                                    <th> Reg </th>
                                    <th> Ta </th>
                                    <th> Tb </th>
                                    <th> Treg </th>
                                    <th> Tw </th>
                                    <th> Velmax </th>
                                    <th> Velmin </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.govHydroWPIDs.map(
                                        govHydroWPID => 
                                        <tr key = {govHydroWPID.govHydroWPIDId}>
                                             <td> { govHydroWPID.d } </td>
                                             <td> { govHydroWPID.gatmax } </td>
                                             <td> { govHydroWPID.gatmin } </td>
                                             <td> { govHydroWPID.gv1 } </td>
                                             <td> { govHydroWPID.gv2 } </td>
                                             <td> { govHydroWPID.gv3 } </td>
                                             <td> { govHydroWPID.kd } </td>
                                             <td> { govHydroWPID.ki } </td>
                                             <td> { govHydroWPID.kp } </td>
                                             <td> { govHydroWPID.mwbase } </td>
                                             <td> { govHydroWPID.pgv1 } </td>
                                             <td> { govHydroWPID.pgv2 } </td>
                                             <td> { govHydroWPID.pgv3 } </td>
                                             <td> { govHydroWPID.pmax } </td>
                                             <td> { govHydroWPID.pmin } </td>
                                             <td> { govHydroWPID.reg } </td>
                                             <td> { govHydroWPID.ta } </td>
                                             <td> { govHydroWPID.tb } </td>
                                             <td> { govHydroWPID.treg } </td>
                                             <td> { govHydroWPID.tw } </td>
                                             <td> { govHydroWPID.velmax } </td>
                                             <td> { govHydroWPID.velmin } </td>
                                             <td>
                                                 <button onClick={ () => this.editGovHydroWPID(govHydroWPID.govHydroWPIDId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteGovHydroWPID(govHydroWPID.govHydroWPIDId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewGovHydroWPID(govHydroWPID.govHydroWPIDId)} className="btn btn-info btn-sm">View </button>
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

export default ListGovHydroWPIDComponent
