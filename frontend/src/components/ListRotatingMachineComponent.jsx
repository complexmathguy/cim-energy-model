import React, { Component } from 'react'
import RotatingMachineService from '../services/RotatingMachineService'

class ListRotatingMachineComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                rotatingMachines: []
        }
        this.addRotatingMachine = this.addRotatingMachine.bind(this);
        this.editRotatingMachine = this.editRotatingMachine.bind(this);
        this.deleteRotatingMachine = this.deleteRotatingMachine.bind(this);
    }

    deleteRotatingMachine(id){
        RotatingMachineService.deleteRotatingMachine(id).then( res => {
            this.setState({rotatingMachines: this.state.rotatingMachines.filter(rotatingMachine => rotatingMachine.rotatingMachineId !== id)});
        });
    }
    viewRotatingMachine(id){
        this.props.history.push(`/view-rotatingMachine/${id}`);
    }
    editRotatingMachine(id){
        this.props.history.push(`/add-rotatingMachine/${id}`);
    }

    componentDidMount(){
        RotatingMachineService.getRotatingMachines().then((res) => {
            this.setState({ rotatingMachines: res.data});
        });
    }

    addRotatingMachine(){
        this.props.history.push('/add-rotatingMachine/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">RotatingMachine List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addRotatingMachine}> Add RotatingMachine</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> RatedPowerFactor </th>
                                    <th> RatedS </th>
                                    <th> RatedU </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.rotatingMachines.map(
                                        rotatingMachine => 
                                        <tr key = {rotatingMachine.rotatingMachineId}>
                                             <td> { rotatingMachine.ratedPowerFactor } </td>
                                             <td> { rotatingMachine.ratedS } </td>
                                             <td> { rotatingMachine.ratedU } </td>
                                             <td>
                                                 <button onClick={ () => this.editRotatingMachine(rotatingMachine.rotatingMachineId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteRotatingMachine(rotatingMachine.rotatingMachineId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewRotatingMachine(rotatingMachine.rotatingMachineId)} className="btn btn-info btn-sm">View </button>
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

export default ListRotatingMachineComponent
