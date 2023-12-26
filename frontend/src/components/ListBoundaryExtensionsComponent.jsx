import React, { Component } from 'react'
import BoundaryExtensionsService from '../services/BoundaryExtensionsService'

class ListBoundaryExtensionsComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                boundaryExtensionss: []
        }
        this.addBoundaryExtensions = this.addBoundaryExtensions.bind(this);
        this.editBoundaryExtensions = this.editBoundaryExtensions.bind(this);
        this.deleteBoundaryExtensions = this.deleteBoundaryExtensions.bind(this);
    }

    deleteBoundaryExtensions(id){
        BoundaryExtensionsService.deleteBoundaryExtensions(id).then( res => {
            this.setState({boundaryExtensionss: this.state.boundaryExtensionss.filter(boundaryExtensions => boundaryExtensions.boundaryExtensionsId !== id)});
        });
    }
    viewBoundaryExtensions(id){
        this.props.history.push(`/view-boundaryExtensions/${id}`);
    }
    editBoundaryExtensions(id){
        this.props.history.push(`/add-boundaryExtensions/${id}`);
    }

    componentDidMount(){
        BoundaryExtensionsService.getBoundaryExtensionss().then((res) => {
            this.setState({ boundaryExtensionss: res.data});
        });
    }

    addBoundaryExtensions(){
        this.props.history.push('/add-boundaryExtensions/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">BoundaryExtensions List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addBoundaryExtensions}> Add BoundaryExtensions</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> BoundaryPoint </th>
                                    <th> FromEndIsoCode </th>
                                    <th> FromEndName </th>
                                    <th> FromEndNameTso </th>
                                    <th> ToEndIsoCode </th>
                                    <th> ToEndName </th>
                                    <th> ToEndNameTso </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.boundaryExtensionss.map(
                                        boundaryExtensions => 
                                        <tr key = {boundaryExtensions.boundaryExtensionsId}>
                                             <td> { boundaryExtensions.boundaryPoint } </td>
                                             <td> { boundaryExtensions.fromEndIsoCode } </td>
                                             <td> { boundaryExtensions.fromEndName } </td>
                                             <td> { boundaryExtensions.fromEndNameTso } </td>
                                             <td> { boundaryExtensions.toEndIsoCode } </td>
                                             <td> { boundaryExtensions.toEndName } </td>
                                             <td> { boundaryExtensions.toEndNameTso } </td>
                                             <td>
                                                 <button onClick={ () => this.editBoundaryExtensions(boundaryExtensions.boundaryExtensionsId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteBoundaryExtensions(boundaryExtensions.boundaryExtensionsId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewBoundaryExtensions(boundaryExtensions.boundaryExtensionsId)} className="btn btn-info btn-sm">View </button>
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

export default ListBoundaryExtensionsComponent
