import React, { Component } from 'react'
import ControlAreaGeneratingUnitService from '../services/ControlAreaGeneratingUnitService'

class ListControlAreaGeneratingUnitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                controlAreaGeneratingUnits: []
        }
        this.addControlAreaGeneratingUnit = this.addControlAreaGeneratingUnit.bind(this);
        this.editControlAreaGeneratingUnit = this.editControlAreaGeneratingUnit.bind(this);
        this.deleteControlAreaGeneratingUnit = this.deleteControlAreaGeneratingUnit.bind(this);
    }

    deleteControlAreaGeneratingUnit(id){
        ControlAreaGeneratingUnitService.deleteControlAreaGeneratingUnit(id).then( res => {
            this.setState({controlAreaGeneratingUnits: this.state.controlAreaGeneratingUnits.filter(controlAreaGeneratingUnit => controlAreaGeneratingUnit.controlAreaGeneratingUnitId !== id)});
        });
    }
    viewControlAreaGeneratingUnit(id){
        this.props.history.push(`/view-controlAreaGeneratingUnit/${id}`);
    }
    editControlAreaGeneratingUnit(id){
        this.props.history.push(`/add-controlAreaGeneratingUnit/${id}`);
    }

    componentDidMount(){
        ControlAreaGeneratingUnitService.getControlAreaGeneratingUnits().then((res) => {
            this.setState({ controlAreaGeneratingUnits: res.data});
        });
    }

    addControlAreaGeneratingUnit(){
        this.props.history.push('/add-controlAreaGeneratingUnit/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ControlAreaGeneratingUnit List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addControlAreaGeneratingUnit}> Add ControlAreaGeneratingUnit</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.controlAreaGeneratingUnits.map(
                                        controlAreaGeneratingUnit => 
                                        <tr key = {controlAreaGeneratingUnit.controlAreaGeneratingUnitId}>
                                             <td>
                                                 <button onClick={ () => this.editControlAreaGeneratingUnit(controlAreaGeneratingUnit.controlAreaGeneratingUnitId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteControlAreaGeneratingUnit(controlAreaGeneratingUnit.controlAreaGeneratingUnitId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewControlAreaGeneratingUnit(controlAreaGeneratingUnit.controlAreaGeneratingUnitId)} className="btn btn-info btn-sm">View </button>
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

export default ListControlAreaGeneratingUnitComponent
