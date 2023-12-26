import React, { Component } from 'react'
import PhaseTapChangerService from '../services/PhaseTapChangerService'

class ListPhaseTapChangerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                phaseTapChangers: []
        }
        this.addPhaseTapChanger = this.addPhaseTapChanger.bind(this);
        this.editPhaseTapChanger = this.editPhaseTapChanger.bind(this);
        this.deletePhaseTapChanger = this.deletePhaseTapChanger.bind(this);
    }

    deletePhaseTapChanger(id){
        PhaseTapChangerService.deletePhaseTapChanger(id).then( res => {
            this.setState({phaseTapChangers: this.state.phaseTapChangers.filter(phaseTapChanger => phaseTapChanger.phaseTapChangerId !== id)});
        });
    }
    viewPhaseTapChanger(id){
        this.props.history.push(`/view-phaseTapChanger/${id}`);
    }
    editPhaseTapChanger(id){
        this.props.history.push(`/add-phaseTapChanger/${id}`);
    }

    componentDidMount(){
        PhaseTapChangerService.getPhaseTapChangers().then((res) => {
            this.setState({ phaseTapChangers: res.data});
        });
    }

    addPhaseTapChanger(){
        this.props.history.push('/add-phaseTapChanger/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">PhaseTapChanger List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addPhaseTapChanger}> Add PhaseTapChanger</button>
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
                                    this.state.phaseTapChangers.map(
                                        phaseTapChanger => 
                                        <tr key = {phaseTapChanger.phaseTapChangerId}>
                                             <td>
                                                 <button onClick={ () => this.editPhaseTapChanger(phaseTapChanger.phaseTapChangerId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deletePhaseTapChanger(phaseTapChanger.phaseTapChangerId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewPhaseTapChanger(phaseTapChanger.phaseTapChangerId)} className="btn btn-info btn-sm">View </button>
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

export default ListPhaseTapChangerComponent
