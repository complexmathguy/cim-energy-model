import React, { Component } from 'react'
import RotationSpeedService from '../services/RotationSpeedService'

class ListRotationSpeedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                rotationSpeeds: []
        }
        this.addRotationSpeed = this.addRotationSpeed.bind(this);
        this.editRotationSpeed = this.editRotationSpeed.bind(this);
        this.deleteRotationSpeed = this.deleteRotationSpeed.bind(this);
    }

    deleteRotationSpeed(id){
        RotationSpeedService.deleteRotationSpeed(id).then( res => {
            this.setState({rotationSpeeds: this.state.rotationSpeeds.filter(rotationSpeed => rotationSpeed.rotationSpeedId !== id)});
        });
    }
    viewRotationSpeed(id){
        this.props.history.push(`/view-rotationSpeed/${id}`);
    }
    editRotationSpeed(id){
        this.props.history.push(`/add-rotationSpeed/${id}`);
    }

    componentDidMount(){
        RotationSpeedService.getRotationSpeeds().then((res) => {
            this.setState({ rotationSpeeds: res.data});
        });
    }

    addRotationSpeed(){
        this.props.history.push('/add-rotationSpeed/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">RotationSpeed List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addRotationSpeed}> Add RotationSpeed</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> DenominatorMultiplier </th>
                                    <th> DenominatorUnit </th>
                                    <th> Multiplier </th>
                                    <th> Unit </th>
                                    <th> Value </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.rotationSpeeds.map(
                                        rotationSpeed => 
                                        <tr key = {rotationSpeed.rotationSpeedId}>
                                             <td> { rotationSpeed.denominatorMultiplier } </td>
                                             <td> { rotationSpeed.denominatorUnit } </td>
                                             <td> { rotationSpeed.multiplier } </td>
                                             <td> { rotationSpeed.unit } </td>
                                             <td> { rotationSpeed.value } </td>
                                             <td>
                                                 <button onClick={ () => this.editRotationSpeed(rotationSpeed.rotationSpeedId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteRotationSpeed(rotationSpeed.rotationSpeedId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewRotationSpeed(rotationSpeed.rotationSpeedId)} className="btn btn-info btn-sm">View </button>
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

export default ListRotationSpeedComponent
