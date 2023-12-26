import React, { Component } from 'react'
import SynchronousMachineService from '../services/SynchronousMachineService'

class ListSynchronousMachineComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                synchronousMachines: []
        }
        this.addSynchronousMachine = this.addSynchronousMachine.bind(this);
        this.editSynchronousMachine = this.editSynchronousMachine.bind(this);
        this.deleteSynchronousMachine = this.deleteSynchronousMachine.bind(this);
    }

    deleteSynchronousMachine(id){
        SynchronousMachineService.deleteSynchronousMachine(id).then( res => {
            this.setState({synchronousMachines: this.state.synchronousMachines.filter(synchronousMachine => synchronousMachine.synchronousMachineId !== id)});
        });
    }
    viewSynchronousMachine(id){
        this.props.history.push(`/view-synchronousMachine/${id}`);
    }
    editSynchronousMachine(id){
        this.props.history.push(`/add-synchronousMachine/${id}`);
    }

    componentDidMount(){
        SynchronousMachineService.getSynchronousMachines().then((res) => {
            this.setState({ synchronousMachines: res.data});
        });
    }

    addSynchronousMachine(){
        this.props.history.push('/add-synchronousMachine/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">SynchronousMachine List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addSynchronousMachine}> Add SynchronousMachine</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Earthing </th>
                                    <th> EarthingStarPointR </th>
                                    <th> EarthingStarPointX </th>
                                    <th> Ikk </th>
                                    <th> MaxQ </th>
                                    <th> MinQ </th>
                                    <th> Mu </th>
                                    <th> QPercent </th>
                                    <th> R </th>
                                    <th> R0 </th>
                                    <th> R2 </th>
                                    <th> SatDirectSubtransX </th>
                                    <th> SatDirectSyncX </th>
                                    <th> SatDirectTransX </th>
                                    <th> ShortCircuitRotorType </th>
                                    <th> Type </th>
                                    <th> VoltageRegulationRange </th>
                                    <th> X0 </th>
                                    <th> X2 </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.synchronousMachines.map(
                                        synchronousMachine => 
                                        <tr key = {synchronousMachine.synchronousMachineId}>
                                             <td> { synchronousMachine.earthing } </td>
                                             <td> { synchronousMachine.earthingStarPointR } </td>
                                             <td> { synchronousMachine.earthingStarPointX } </td>
                                             <td> { synchronousMachine.ikk } </td>
                                             <td> { synchronousMachine.maxQ } </td>
                                             <td> { synchronousMachine.minQ } </td>
                                             <td> { synchronousMachine.mu } </td>
                                             <td> { synchronousMachine.qPercent } </td>
                                             <td> { synchronousMachine.r } </td>
                                             <td> { synchronousMachine.r0 } </td>
                                             <td> { synchronousMachine.r2 } </td>
                                             <td> { synchronousMachine.satDirectSubtransX } </td>
                                             <td> { synchronousMachine.satDirectSyncX } </td>
                                             <td> { synchronousMachine.satDirectTransX } </td>
                                             <td> { synchronousMachine.shortCircuitRotorType } </td>
                                             <td> { synchronousMachine.type } </td>
                                             <td> { synchronousMachine.voltageRegulationRange } </td>
                                             <td> { synchronousMachine.x0 } </td>
                                             <td> { synchronousMachine.x2 } </td>
                                             <td>
                                                 <button onClick={ () => this.editSynchronousMachine(synchronousMachine.synchronousMachineId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteSynchronousMachine(synchronousMachine.synchronousMachineId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewSynchronousMachine(synchronousMachine.synchronousMachineId)} className="btn btn-info btn-sm">View </button>
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

export default ListSynchronousMachineComponent
