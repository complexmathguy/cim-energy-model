import React, { Component } from 'react'
import ActivePowerService from '../services/ActivePowerService'

class ListActivePowerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                activePowers: []
        }
        this.addActivePower = this.addActivePower.bind(this);
        this.editActivePower = this.editActivePower.bind(this);
        this.deleteActivePower = this.deleteActivePower.bind(this);
    }

    deleteActivePower(id){
        ActivePowerService.deleteActivePower(id).then( res => {
            this.setState({activePowers: this.state.activePowers.filter(activePower => activePower.activePowerId !== id)});
        });
    }
    viewActivePower(id){
        this.props.history.push(`/view-activePower/${id}`);
    }
    editActivePower(id){
        this.props.history.push(`/add-activePower/${id}`);
    }

    componentDidMount(){
        ActivePowerService.getActivePowers().then((res) => {
            this.setState({ activePowers: res.data});
        });
    }

    addActivePower(){
        this.props.history.push('/add-activePower/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ActivePower List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addActivePower}> Add ActivePower</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Multiplier </th>
                                    <th> Unit </th>
                                    <th> Value </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.activePowers.map(
                                        activePower => 
                                        <tr key = {activePower.activePowerId}>
                                             <td> { activePower.multiplier } </td>
                                             <td> { activePower.unit } </td>
                                             <td> { activePower.value } </td>
                                             <td>
                                                 <button onClick={ () => this.editActivePower(activePower.activePowerId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteActivePower(activePower.activePowerId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewActivePower(activePower.activePowerId)} className="btn btn-info btn-sm">View </button>
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

export default ListActivePowerComponent
