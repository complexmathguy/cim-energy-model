import React, { Component } from 'react'
import PhaseTapChangerAsymmetricalService from '../services/PhaseTapChangerAsymmetricalService'

class ListPhaseTapChangerAsymmetricalComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                phaseTapChangerAsymmetricals: []
        }
        this.addPhaseTapChangerAsymmetrical = this.addPhaseTapChangerAsymmetrical.bind(this);
        this.editPhaseTapChangerAsymmetrical = this.editPhaseTapChangerAsymmetrical.bind(this);
        this.deletePhaseTapChangerAsymmetrical = this.deletePhaseTapChangerAsymmetrical.bind(this);
    }

    deletePhaseTapChangerAsymmetrical(id){
        PhaseTapChangerAsymmetricalService.deletePhaseTapChangerAsymmetrical(id).then( res => {
            this.setState({phaseTapChangerAsymmetricals: this.state.phaseTapChangerAsymmetricals.filter(phaseTapChangerAsymmetrical => phaseTapChangerAsymmetrical.phaseTapChangerAsymmetricalId !== id)});
        });
    }
    viewPhaseTapChangerAsymmetrical(id){
        this.props.history.push(`/view-phaseTapChangerAsymmetrical/${id}`);
    }
    editPhaseTapChangerAsymmetrical(id){
        this.props.history.push(`/add-phaseTapChangerAsymmetrical/${id}`);
    }

    componentDidMount(){
        PhaseTapChangerAsymmetricalService.getPhaseTapChangerAsymmetricals().then((res) => {
            this.setState({ phaseTapChangerAsymmetricals: res.data});
        });
    }

    addPhaseTapChangerAsymmetrical(){
        this.props.history.push('/add-phaseTapChangerAsymmetrical/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">PhaseTapChangerAsymmetrical List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addPhaseTapChangerAsymmetrical}> Add PhaseTapChangerAsymmetrical</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> WindingConnectionAngle </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.phaseTapChangerAsymmetricals.map(
                                        phaseTapChangerAsymmetrical => 
                                        <tr key = {phaseTapChangerAsymmetrical.phaseTapChangerAsymmetricalId}>
                                             <td> { phaseTapChangerAsymmetrical.windingConnectionAngle } </td>
                                             <td>
                                                 <button onClick={ () => this.editPhaseTapChangerAsymmetrical(phaseTapChangerAsymmetrical.phaseTapChangerAsymmetricalId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deletePhaseTapChangerAsymmetrical(phaseTapChangerAsymmetrical.phaseTapChangerAsymmetricalId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewPhaseTapChangerAsymmetrical(phaseTapChangerAsymmetrical.phaseTapChangerAsymmetricalId)} className="btn btn-info btn-sm">View </button>
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

export default ListPhaseTapChangerAsymmetricalComponent
