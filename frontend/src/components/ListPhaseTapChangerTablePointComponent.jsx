import React, { Component } from 'react'
import PhaseTapChangerTablePointService from '../services/PhaseTapChangerTablePointService'

class ListPhaseTapChangerTablePointComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                phaseTapChangerTablePoints: []
        }
        this.addPhaseTapChangerTablePoint = this.addPhaseTapChangerTablePoint.bind(this);
        this.editPhaseTapChangerTablePoint = this.editPhaseTapChangerTablePoint.bind(this);
        this.deletePhaseTapChangerTablePoint = this.deletePhaseTapChangerTablePoint.bind(this);
    }

    deletePhaseTapChangerTablePoint(id){
        PhaseTapChangerTablePointService.deletePhaseTapChangerTablePoint(id).then( res => {
            this.setState({phaseTapChangerTablePoints: this.state.phaseTapChangerTablePoints.filter(phaseTapChangerTablePoint => phaseTapChangerTablePoint.phaseTapChangerTablePointId !== id)});
        });
    }
    viewPhaseTapChangerTablePoint(id){
        this.props.history.push(`/view-phaseTapChangerTablePoint/${id}`);
    }
    editPhaseTapChangerTablePoint(id){
        this.props.history.push(`/add-phaseTapChangerTablePoint/${id}`);
    }

    componentDidMount(){
        PhaseTapChangerTablePointService.getPhaseTapChangerTablePoints().then((res) => {
            this.setState({ phaseTapChangerTablePoints: res.data});
        });
    }

    addPhaseTapChangerTablePoint(){
        this.props.history.push('/add-phaseTapChangerTablePoint/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">PhaseTapChangerTablePoint List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addPhaseTapChangerTablePoint}> Add PhaseTapChangerTablePoint</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Angle </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.phaseTapChangerTablePoints.map(
                                        phaseTapChangerTablePoint => 
                                        <tr key = {phaseTapChangerTablePoint.phaseTapChangerTablePointId}>
                                             <td> { phaseTapChangerTablePoint.angle } </td>
                                             <td>
                                                 <button onClick={ () => this.editPhaseTapChangerTablePoint(phaseTapChangerTablePoint.phaseTapChangerTablePointId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deletePhaseTapChangerTablePoint(phaseTapChangerTablePoint.phaseTapChangerTablePointId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewPhaseTapChangerTablePoint(phaseTapChangerTablePoint.phaseTapChangerTablePointId)} className="btn btn-info btn-sm">View </button>
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

export default ListPhaseTapChangerTablePointComponent
