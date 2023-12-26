import React, { Component } from 'react'
import ExtensionVersionService from '../services/ExtensionVersionService'

class ListExtensionVersionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                extensionVersions: []
        }
        this.addExtensionVersion = this.addExtensionVersion.bind(this);
        this.editExtensionVersion = this.editExtensionVersion.bind(this);
        this.deleteExtensionVersion = this.deleteExtensionVersion.bind(this);
    }

    deleteExtensionVersion(id){
        ExtensionVersionService.deleteExtensionVersion(id).then( res => {
            this.setState({extensionVersions: this.state.extensionVersions.filter(extensionVersion => extensionVersion.extensionVersionId !== id)});
        });
    }
    viewExtensionVersion(id){
        this.props.history.push(`/view-extensionVersion/${id}`);
    }
    editExtensionVersion(id){
        this.props.history.push(`/add-extensionVersion/${id}`);
    }

    componentDidMount(){
        ExtensionVersionService.getExtensionVersions().then((res) => {
            this.setState({ extensionVersions: res.data});
        });
    }

    addExtensionVersion(){
        this.props.history.push('/add-extensionVersion/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ExtensionVersion List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addExtensionVersion}> Add ExtensionVersion</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Date </th>
                                    <th> NamespaceURI </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.extensionVersions.map(
                                        extensionVersion => 
                                        <tr key = {extensionVersion.extensionVersionId}>
                                             <td> { extensionVersion.date } </td>
                                             <td> { extensionVersion.namespaceURI } </td>
                                             <td>
                                                 <button onClick={ () => this.editExtensionVersion(extensionVersion.extensionVersionId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteExtensionVersion(extensionVersion.extensionVersionId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewExtensionVersion(extensionVersion.extensionVersionId)} className="btn btn-info btn-sm">View </button>
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

export default ListExtensionVersionComponent
