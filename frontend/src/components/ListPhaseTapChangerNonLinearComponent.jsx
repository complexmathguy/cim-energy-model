import React, { Component } from 'react'
import PhaseTapChangerNonLinearService from '../services/PhaseTapChangerNonLinearService'

class ListPhaseTapChangerNonLinearComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                phaseTapChangerNonLinears: []
        }
        this.addPhaseTapChangerNonLinear = this.addPhaseTapChangerNonLinear.bind(this);
        this.editPhaseTapChangerNonLinear = this.editPhaseTapChangerNonLinear.bind(this);
        this.deletePhaseTapChangerNonLinear = this.deletePhaseTapChangerNonLinear.bind(this);
    }

    deletePhaseTapChangerNonLinear(id){
        PhaseTapChangerNonLinearService.deletePhaseTapChangerNonLinear(id).then( res => {
            this.setState({phaseTapChangerNonLinears: this.state.phaseTapChangerNonLinears.filter(phaseTapChangerNonLinear => phaseTapChangerNonLinear.phaseTapChangerNonLinearId !== id)});
        });
    }
    viewPhaseTapChangerNonLinear(id){
        this.props.history.push(`/view-phaseTapChangerNonLinear/${id}`);
    }
    editPhaseTapChangerNonLinear(id){
        this.props.history.push(`/add-phaseTapChangerNonLinear/${id}`);
    }

    componentDidMount(){
        PhaseTapChangerNonLinearService.getPhaseTapChangerNonLinears().then((res) => {
            this.setState({ phaseTapChangerNonLinears: res.data});
        });
    }

    addPhaseTapChangerNonLinear(){
        this.props.history.push('/add-phaseTapChangerNonLinear/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">PhaseTapChangerNonLinear List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addPhaseTapChangerNonLinear}> Add PhaseTapChangerNonLinear</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> VoltageStepIncrement </th>
                                    <th> XMax </th>
                                    <th> XMin </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.phaseTapChangerNonLinears.map(
                                        phaseTapChangerNonLinear => 
                                        <tr key = {phaseTapChangerNonLinear.phaseTapChangerNonLinearId}>
                                             <td> { phaseTapChangerNonLinear.voltageStepIncrement } </td>
                                             <td> { phaseTapChangerNonLinear.xMax } </td>
                                             <td> { phaseTapChangerNonLinear.xMin } </td>
                                             <td>
                                                 <button onClick={ () => this.editPhaseTapChangerNonLinear(phaseTapChangerNonLinear.phaseTapChangerNonLinearId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deletePhaseTapChangerNonLinear(phaseTapChangerNonLinear.phaseTapChangerNonLinearId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewPhaseTapChangerNonLinear(phaseTapChangerNonLinear.phaseTapChangerNonLinearId)} className="btn btn-info btn-sm">View </button>
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

export default ListPhaseTapChangerNonLinearComponent
