import React, { Component } from 'react'
import LoadUserDefinedService from '../services/LoadUserDefinedService'

class ListLoadUserDefinedComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                loadUserDefineds: []
        }
        this.addLoadUserDefined = this.addLoadUserDefined.bind(this);
        this.editLoadUserDefined = this.editLoadUserDefined.bind(this);
        this.deleteLoadUserDefined = this.deleteLoadUserDefined.bind(this);
    }

    deleteLoadUserDefined(id){
        LoadUserDefinedService.deleteLoadUserDefined(id).then( res => {
            this.setState({loadUserDefineds: this.state.loadUserDefineds.filter(loadUserDefined => loadUserDefined.loadUserDefinedId !== id)});
        });
    }
    viewLoadUserDefined(id){
        this.props.history.push(`/view-loadUserDefined/${id}`);
    }
    editLoadUserDefined(id){
        this.props.history.push(`/add-loadUserDefined/${id}`);
    }

    componentDidMount(){
        LoadUserDefinedService.getLoadUserDefineds().then((res) => {
            this.setState({ loadUserDefineds: res.data});
        });
    }

    addLoadUserDefined(){
        this.props.history.push('/add-loadUserDefined/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">LoadUserDefined List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addLoadUserDefined}> Add LoadUserDefined</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Proprietary </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.loadUserDefineds.map(
                                        loadUserDefined => 
                                        <tr key = {loadUserDefined.loadUserDefinedId}>
                                             <td> { loadUserDefined.proprietary } </td>
                                             <td>
                                                 <button onClick={ () => this.editLoadUserDefined(loadUserDefined.loadUserDefinedId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteLoadUserDefined(loadUserDefined.loadUserDefinedId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewLoadUserDefined(loadUserDefined.loadUserDefinedId)} className="btn btn-info btn-sm">View </button>
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

export default ListLoadUserDefinedComponent
