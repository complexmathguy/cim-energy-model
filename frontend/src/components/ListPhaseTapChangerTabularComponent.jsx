import React, { Component } from 'react'
import PhaseTapChangerTabularService from '../services/PhaseTapChangerTabularService'

class ListPhaseTapChangerTabularComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                phaseTapChangerTabulars: []
        }
        this.addPhaseTapChangerTabular = this.addPhaseTapChangerTabular.bind(this);
        this.editPhaseTapChangerTabular = this.editPhaseTapChangerTabular.bind(this);
        this.deletePhaseTapChangerTabular = this.deletePhaseTapChangerTabular.bind(this);
    }

    deletePhaseTapChangerTabular(id){
        PhaseTapChangerTabularService.deletePhaseTapChangerTabular(id).then( res => {
            this.setState({phaseTapChangerTabulars: this.state.phaseTapChangerTabulars.filter(phaseTapChangerTabular => phaseTapChangerTabular.phaseTapChangerTabularId !== id)});
        });
    }
    viewPhaseTapChangerTabular(id){
        this.props.history.push(`/view-phaseTapChangerTabular/${id}`);
    }
    editPhaseTapChangerTabular(id){
        this.props.history.push(`/add-phaseTapChangerTabular/${id}`);
    }

    componentDidMount(){
        PhaseTapChangerTabularService.getPhaseTapChangerTabulars().then((res) => {
            this.setState({ phaseTapChangerTabulars: res.data});
        });
    }

    addPhaseTapChangerTabular(){
        this.props.history.push('/add-phaseTapChangerTabular/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">PhaseTapChangerTabular List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addPhaseTapChangerTabular}> Add PhaseTapChangerTabular</button>
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
                                    this.state.phaseTapChangerTabulars.map(
                                        phaseTapChangerTabular => 
                                        <tr key = {phaseTapChangerTabular.phaseTapChangerTabularId}>
                                             <td>
                                                 <button onClick={ () => this.editPhaseTapChangerTabular(phaseTapChangerTabular.phaseTapChangerTabularId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deletePhaseTapChangerTabular(phaseTapChangerTabular.phaseTapChangerTabularId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewPhaseTapChangerTabular(phaseTapChangerTabular.phaseTapChangerTabularId)} className="btn btn-info btn-sm">View </button>
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

export default ListPhaseTapChangerTabularComponent
