import React, { Component } from 'react'
import PhaseTapChangerLinearService from '../services/PhaseTapChangerLinearService'

class ListPhaseTapChangerLinearComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                phaseTapChangerLinears: []
        }
        this.addPhaseTapChangerLinear = this.addPhaseTapChangerLinear.bind(this);
        this.editPhaseTapChangerLinear = this.editPhaseTapChangerLinear.bind(this);
        this.deletePhaseTapChangerLinear = this.deletePhaseTapChangerLinear.bind(this);
    }

    deletePhaseTapChangerLinear(id){
        PhaseTapChangerLinearService.deletePhaseTapChangerLinear(id).then( res => {
            this.setState({phaseTapChangerLinears: this.state.phaseTapChangerLinears.filter(phaseTapChangerLinear => phaseTapChangerLinear.phaseTapChangerLinearId !== id)});
        });
    }
    viewPhaseTapChangerLinear(id){
        this.props.history.push(`/view-phaseTapChangerLinear/${id}`);
    }
    editPhaseTapChangerLinear(id){
        this.props.history.push(`/add-phaseTapChangerLinear/${id}`);
    }

    componentDidMount(){
        PhaseTapChangerLinearService.getPhaseTapChangerLinears().then((res) => {
            this.setState({ phaseTapChangerLinears: res.data});
        });
    }

    addPhaseTapChangerLinear(){
        this.props.history.push('/add-phaseTapChangerLinear/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">PhaseTapChangerLinear List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addPhaseTapChangerLinear}> Add PhaseTapChangerLinear</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> StepPhaseShiftIncrement </th>
                                    <th> XMax </th>
                                    <th> XMin </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.phaseTapChangerLinears.map(
                                        phaseTapChangerLinear => 
                                        <tr key = {phaseTapChangerLinear.phaseTapChangerLinearId}>
                                             <td> { phaseTapChangerLinear.stepPhaseShiftIncrement } </td>
                                             <td> { phaseTapChangerLinear.xMax } </td>
                                             <td> { phaseTapChangerLinear.xMin } </td>
                                             <td>
                                                 <button onClick={ () => this.editPhaseTapChangerLinear(phaseTapChangerLinear.phaseTapChangerLinearId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deletePhaseTapChangerLinear(phaseTapChangerLinear.phaseTapChangerLinearId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewPhaseTapChangerLinear(phaseTapChangerLinear.phaseTapChangerLinearId)} className="btn btn-info btn-sm">View </button>
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

export default ListPhaseTapChangerLinearComponent
