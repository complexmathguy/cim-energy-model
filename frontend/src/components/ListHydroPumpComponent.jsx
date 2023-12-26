import React, { Component } from 'react'
import HydroPumpService from '../services/HydroPumpService'

class ListHydroPumpComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                hydroPumps: []
        }
        this.addHydroPump = this.addHydroPump.bind(this);
        this.editHydroPump = this.editHydroPump.bind(this);
        this.deleteHydroPump = this.deleteHydroPump.bind(this);
    }

    deleteHydroPump(id){
        HydroPumpService.deleteHydroPump(id).then( res => {
            this.setState({hydroPumps: this.state.hydroPumps.filter(hydroPump => hydroPump.hydroPumpId !== id)});
        });
    }
    viewHydroPump(id){
        this.props.history.push(`/view-hydroPump/${id}`);
    }
    editHydroPump(id){
        this.props.history.push(`/add-hydroPump/${id}`);
    }

    componentDidMount(){
        HydroPumpService.getHydroPumps().then((res) => {
            this.setState({ hydroPumps: res.data});
        });
    }

    addHydroPump(){
        this.props.history.push('/add-hydroPump/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">HydroPump List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addHydroPump}> Add HydroPump</button>
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
                                    this.state.hydroPumps.map(
                                        hydroPump => 
                                        <tr key = {hydroPump.hydroPumpId}>
                                             <td>
                                                 <button onClick={ () => this.editHydroPump(hydroPump.hydroPumpId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteHydroPump(hydroPump.hydroPumpId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewHydroPump(hydroPump.hydroPumpId)} className="btn btn-info btn-sm">View </button>
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

export default ListHydroPumpComponent
