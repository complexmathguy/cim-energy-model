import React, { Component } from 'react'
import DisconnectorService from '../services/DisconnectorService'

class ListDisconnectorComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                disconnectors: []
        }
        this.addDisconnector = this.addDisconnector.bind(this);
        this.editDisconnector = this.editDisconnector.bind(this);
        this.deleteDisconnector = this.deleteDisconnector.bind(this);
    }

    deleteDisconnector(id){
        DisconnectorService.deleteDisconnector(id).then( res => {
            this.setState({disconnectors: this.state.disconnectors.filter(disconnector => disconnector.disconnectorId !== id)});
        });
    }
    viewDisconnector(id){
        this.props.history.push(`/view-disconnector/${id}`);
    }
    editDisconnector(id){
        this.props.history.push(`/add-disconnector/${id}`);
    }

    componentDidMount(){
        DisconnectorService.getDisconnectors().then((res) => {
            this.setState({ disconnectors: res.data});
        });
    }

    addDisconnector(){
        this.props.history.push('/add-disconnector/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">Disconnector List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addDisconnector}> Add Disconnector</button>
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
                                    this.state.disconnectors.map(
                                        disconnector => 
                                        <tr key = {disconnector.disconnectorId}>
                                             <td>
                                                 <button onClick={ () => this.editDisconnector(disconnector.disconnectorId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteDisconnector(disconnector.disconnectorId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewDisconnector(disconnector.disconnectorId)} className="btn btn-info btn-sm">View </button>
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

export default ListDisconnectorComponent
