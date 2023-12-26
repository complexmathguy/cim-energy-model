import React, { Component } from 'react'
import PowerTransformerEndService from '../services/PowerTransformerEndService'

class ListPowerTransformerEndComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                powerTransformerEnds: []
        }
        this.addPowerTransformerEnd = this.addPowerTransformerEnd.bind(this);
        this.editPowerTransformerEnd = this.editPowerTransformerEnd.bind(this);
        this.deletePowerTransformerEnd = this.deletePowerTransformerEnd.bind(this);
    }

    deletePowerTransformerEnd(id){
        PowerTransformerEndService.deletePowerTransformerEnd(id).then( res => {
            this.setState({powerTransformerEnds: this.state.powerTransformerEnds.filter(powerTransformerEnd => powerTransformerEnd.powerTransformerEndId !== id)});
        });
    }
    viewPowerTransformerEnd(id){
        this.props.history.push(`/view-powerTransformerEnd/${id}`);
    }
    editPowerTransformerEnd(id){
        this.props.history.push(`/add-powerTransformerEnd/${id}`);
    }

    componentDidMount(){
        PowerTransformerEndService.getPowerTransformerEnds().then((res) => {
            this.setState({ powerTransformerEnds: res.data});
        });
    }

    addPowerTransformerEnd(){
        this.props.history.push('/add-powerTransformerEnd/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">PowerTransformerEnd List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addPowerTransformerEnd}> Add PowerTransformerEnd</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> B </th>
                                    <th> B0 </th>
                                    <th> ConnectionKind </th>
                                    <th> G </th>
                                    <th> G0 </th>
                                    <th> PhaseAngleClock </th>
                                    <th> R </th>
                                    <th> R0 </th>
                                    <th> RatedS </th>
                                    <th> RatedU </th>
                                    <th> X </th>
                                    <th> X0 </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.powerTransformerEnds.map(
                                        powerTransformerEnd => 
                                        <tr key = {powerTransformerEnd.powerTransformerEndId}>
                                             <td> { powerTransformerEnd.b } </td>
                                             <td> { powerTransformerEnd.b0 } </td>
                                             <td> { powerTransformerEnd.connectionKind } </td>
                                             <td> { powerTransformerEnd.g } </td>
                                             <td> { powerTransformerEnd.g0 } </td>
                                             <td> { powerTransformerEnd.phaseAngleClock } </td>
                                             <td> { powerTransformerEnd.r } </td>
                                             <td> { powerTransformerEnd.r0 } </td>
                                             <td> { powerTransformerEnd.ratedS } </td>
                                             <td> { powerTransformerEnd.ratedU } </td>
                                             <td> { powerTransformerEnd.x } </td>
                                             <td> { powerTransformerEnd.x0 } </td>
                                             <td>
                                                 <button onClick={ () => this.editPowerTransformerEnd(powerTransformerEnd.powerTransformerEndId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deletePowerTransformerEnd(powerTransformerEnd.powerTransformerEndId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewPowerTransformerEnd(powerTransformerEnd.powerTransformerEndId)} className="btn btn-info btn-sm">View </button>
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

export default ListPowerTransformerEndComponent
