import React, { Component } from 'react'
import PhaseTapChangerSymmetricalService from '../services/PhaseTapChangerSymmetricalService'

class ListPhaseTapChangerSymmetricalComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                phaseTapChangerSymmetricals: []
        }
        this.addPhaseTapChangerSymmetrical = this.addPhaseTapChangerSymmetrical.bind(this);
        this.editPhaseTapChangerSymmetrical = this.editPhaseTapChangerSymmetrical.bind(this);
        this.deletePhaseTapChangerSymmetrical = this.deletePhaseTapChangerSymmetrical.bind(this);
    }

    deletePhaseTapChangerSymmetrical(id){
        PhaseTapChangerSymmetricalService.deletePhaseTapChangerSymmetrical(id).then( res => {
            this.setState({phaseTapChangerSymmetricals: this.state.phaseTapChangerSymmetricals.filter(phaseTapChangerSymmetrical => phaseTapChangerSymmetrical.phaseTapChangerSymmetricalId !== id)});
        });
    }
    viewPhaseTapChangerSymmetrical(id){
        this.props.history.push(`/view-phaseTapChangerSymmetrical/${id}`);
    }
    editPhaseTapChangerSymmetrical(id){
        this.props.history.push(`/add-phaseTapChangerSymmetrical/${id}`);
    }

    componentDidMount(){
        PhaseTapChangerSymmetricalService.getPhaseTapChangerSymmetricals().then((res) => {
            this.setState({ phaseTapChangerSymmetricals: res.data});
        });
    }

    addPhaseTapChangerSymmetrical(){
        this.props.history.push('/add-phaseTapChangerSymmetrical/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">PhaseTapChangerSymmetrical List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addPhaseTapChangerSymmetrical}> Add PhaseTapChangerSymmetrical</button>
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
                                    this.state.phaseTapChangerSymmetricals.map(
                                        phaseTapChangerSymmetrical => 
                                        <tr key = {phaseTapChangerSymmetrical.phaseTapChangerSymmetricalId}>
                                             <td>
                                                 <button onClick={ () => this.editPhaseTapChangerSymmetrical(phaseTapChangerSymmetrical.phaseTapChangerSymmetricalId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deletePhaseTapChangerSymmetrical(phaseTapChangerSymmetrical.phaseTapChangerSymmetricalId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewPhaseTapChangerSymmetrical(phaseTapChangerSymmetrical.phaseTapChangerSymmetricalId)} className="btn btn-info btn-sm">View </button>
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

export default ListPhaseTapChangerSymmetricalComponent
