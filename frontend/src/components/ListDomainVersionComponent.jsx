import React, { Component } from 'react'
import DomainVersionService from '../services/DomainVersionService'

class ListDomainVersionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                domainVersions: []
        }
        this.addDomainVersion = this.addDomainVersion.bind(this);
        this.editDomainVersion = this.editDomainVersion.bind(this);
        this.deleteDomainVersion = this.deleteDomainVersion.bind(this);
    }

    deleteDomainVersion(id){
        DomainVersionService.deleteDomainVersion(id).then( res => {
            this.setState({domainVersions: this.state.domainVersions.filter(domainVersion => domainVersion.domainVersionId !== id)});
        });
    }
    viewDomainVersion(id){
        this.props.history.push(`/view-domainVersion/${id}`);
    }
    editDomainVersion(id){
        this.props.history.push(`/add-domainVersion/${id}`);
    }

    componentDidMount(){
        DomainVersionService.getDomainVersions().then((res) => {
            this.setState({ domainVersions: res.data});
        });
    }

    addDomainVersion(){
        this.props.history.push('/add-domainVersion/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">DomainVersion List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addDomainVersion}> Add DomainVersion</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> BaseUML </th>
                                    <th> Date </th>
                                    <th> EntsoeUML </th>
                                    <th> Version </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.domainVersions.map(
                                        domainVersion => 
                                        <tr key = {domainVersion.domainVersionId}>
                                             <td> { domainVersion.baseUML } </td>
                                             <td> { domainVersion.date } </td>
                                             <td> { domainVersion.entsoeUML } </td>
                                             <td> { domainVersion.version } </td>
                                             <td>
                                                 <button onClick={ () => this.editDomainVersion(domainVersion.domainVersionId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteDomainVersion(domainVersion.domainVersionId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewDomainVersion(domainVersion.domainVersionId)} className="btn btn-info btn-sm">View </button>
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

export default ListDomainVersionComponent
