import React, { Component } from 'react'
import DCDisconnectorService from '../services/DCDisconnectorService'

class ListDCDisconnectorComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                dCDisconnectors: []
        }
        this.addDCDisconnector = this.addDCDisconnector.bind(this);
        this.editDCDisconnector = this.editDCDisconnector.bind(this);
        this.deleteDCDisconnector = this.deleteDCDisconnector.bind(this);
    }

    deleteDCDisconnector(id){
        DCDisconnectorService.deleteDCDisconnector(id).then( res => {
            this.setState({dCDisconnectors: this.state.dCDisconnectors.filter(dCDisconnector => dCDisconnector.dCDisconnectorId !== id)});
        });
    }
    viewDCDisconnector(id){
        this.props.history.push(`/view-dCDisconnector/${id}`);
    }
    editDCDisconnector(id){
        this.props.history.push(`/add-dCDisconnector/${id}`);
    }

    componentDidMount(){
        DCDisconnectorService.getDCDisconnectors().then((res) => {
            this.setState({ dCDisconnectors: res.data});
        });
    }

    addDCDisconnector(){
        this.props.history.push('/add-dCDisconnector/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">DCDisconnector List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addDCDisconnector}> Add DCDisconnector</button>
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
                                    this.state.dCDisconnectors.map(
                                        dCDisconnector => 
                                        <tr key = {dCDisconnector.dCDisconnectorId}>
                                             <td>
                                                 <button onClick={ () => this.editDCDisconnector(dCDisconnector.dCDisconnectorId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteDCDisconnector(dCDisconnector.dCDisconnectorId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewDCDisconnector(dCDisconnector.dCDisconnectorId)} className="btn btn-info btn-sm">View </button>
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

export default ListDCDisconnectorComponent
