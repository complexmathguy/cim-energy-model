import React, { Component } from 'react'
import VoltageLevelService from '../services/VoltageLevelService'

class ListVoltageLevelComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                voltageLevels: []
        }
        this.addVoltageLevel = this.addVoltageLevel.bind(this);
        this.editVoltageLevel = this.editVoltageLevel.bind(this);
        this.deleteVoltageLevel = this.deleteVoltageLevel.bind(this);
    }

    deleteVoltageLevel(id){
        VoltageLevelService.deleteVoltageLevel(id).then( res => {
            this.setState({voltageLevels: this.state.voltageLevels.filter(voltageLevel => voltageLevel.voltageLevelId !== id)});
        });
    }
    viewVoltageLevel(id){
        this.props.history.push(`/view-voltageLevel/${id}`);
    }
    editVoltageLevel(id){
        this.props.history.push(`/add-voltageLevel/${id}`);
    }

    componentDidMount(){
        VoltageLevelService.getVoltageLevels().then((res) => {
            this.setState({ voltageLevels: res.data});
        });
    }

    addVoltageLevel(){
        this.props.history.push('/add-voltageLevel/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">VoltageLevel List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addVoltageLevel}> Add VoltageLevel</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> HighVoltageLimit </th>
                                    <th> LowVoltageLimit </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.voltageLevels.map(
                                        voltageLevel => 
                                        <tr key = {voltageLevel.voltageLevelId}>
                                             <td> { voltageLevel.highVoltageLimit } </td>
                                             <td> { voltageLevel.lowVoltageLimit } </td>
                                             <td>
                                                 <button onClick={ () => this.editVoltageLevel(voltageLevel.voltageLevelId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteVoltageLevel(voltageLevel.voltageLevelId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewVoltageLevel(voltageLevel.voltageLevelId)} className="btn btn-info btn-sm">View </button>
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

export default ListVoltageLevelComponent
