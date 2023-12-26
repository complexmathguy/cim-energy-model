import React, { Component } from 'react'
import GroundDisconnectorService from '../services/GroundDisconnectorService'

class ListGroundDisconnectorComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                groundDisconnectors: []
        }
        this.addGroundDisconnector = this.addGroundDisconnector.bind(this);
        this.editGroundDisconnector = this.editGroundDisconnector.bind(this);
        this.deleteGroundDisconnector = this.deleteGroundDisconnector.bind(this);
    }

    deleteGroundDisconnector(id){
        GroundDisconnectorService.deleteGroundDisconnector(id).then( res => {
            this.setState({groundDisconnectors: this.state.groundDisconnectors.filter(groundDisconnector => groundDisconnector.groundDisconnectorId !== id)});
        });
    }
    viewGroundDisconnector(id){
        this.props.history.push(`/view-groundDisconnector/${id}`);
    }
    editGroundDisconnector(id){
        this.props.history.push(`/add-groundDisconnector/${id}`);
    }

    componentDidMount(){
        GroundDisconnectorService.getGroundDisconnectors().then((res) => {
            this.setState({ groundDisconnectors: res.data});
        });
    }

    addGroundDisconnector(){
        this.props.history.push('/add-groundDisconnector/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">GroundDisconnector List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addGroundDisconnector}> Add GroundDisconnector</button>
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
                                    this.state.groundDisconnectors.map(
                                        groundDisconnector => 
                                        <tr key = {groundDisconnector.groundDisconnectorId}>
                                             <td>
                                                 <button onClick={ () => this.editGroundDisconnector(groundDisconnector.groundDisconnectorId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteGroundDisconnector(groundDisconnector.groundDisconnectorId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewGroundDisconnector(groundDisconnector.groundDisconnectorId)} className="btn btn-info btn-sm">View </button>
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

export default ListGroundDisconnectorComponent
