import React, { Component } from 'react'
import NuclearGeneratingUnitService from '../services/NuclearGeneratingUnitService'

class ListNuclearGeneratingUnitComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                nuclearGeneratingUnits: []
        }
        this.addNuclearGeneratingUnit = this.addNuclearGeneratingUnit.bind(this);
        this.editNuclearGeneratingUnit = this.editNuclearGeneratingUnit.bind(this);
        this.deleteNuclearGeneratingUnit = this.deleteNuclearGeneratingUnit.bind(this);
    }

    deleteNuclearGeneratingUnit(id){
        NuclearGeneratingUnitService.deleteNuclearGeneratingUnit(id).then( res => {
            this.setState({nuclearGeneratingUnits: this.state.nuclearGeneratingUnits.filter(nuclearGeneratingUnit => nuclearGeneratingUnit.nuclearGeneratingUnitId !== id)});
        });
    }
    viewNuclearGeneratingUnit(id){
        this.props.history.push(`/view-nuclearGeneratingUnit/${id}`);
    }
    editNuclearGeneratingUnit(id){
        this.props.history.push(`/add-nuclearGeneratingUnit/${id}`);
    }

    componentDidMount(){
        NuclearGeneratingUnitService.getNuclearGeneratingUnits().then((res) => {
            this.setState({ nuclearGeneratingUnits: res.data});
        });
    }

    addNuclearGeneratingUnit(){
        this.props.history.push('/add-nuclearGeneratingUnit/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">NuclearGeneratingUnit List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addNuclearGeneratingUnit}> Add NuclearGeneratingUnit</button>
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
                                    this.state.nuclearGeneratingUnits.map(
                                        nuclearGeneratingUnit => 
                                        <tr key = {nuclearGeneratingUnit.nuclearGeneratingUnitId}>
                                             <td>
                                                 <button onClick={ () => this.editNuclearGeneratingUnit(nuclearGeneratingUnit.nuclearGeneratingUnitId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteNuclearGeneratingUnit(nuclearGeneratingUnit.nuclearGeneratingUnitId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewNuclearGeneratingUnit(nuclearGeneratingUnit.nuclearGeneratingUnitId)} className="btn btn-info btn-sm">View </button>
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

export default ListNuclearGeneratingUnitComponent
