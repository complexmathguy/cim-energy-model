import React, { Component } from 'react'
import UnresolvednameService from '../services/UnresolvednameService'

class ListUnresolvednameComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                unresolvednames: []
        }
        this.addUnresolvedname = this.addUnresolvedname.bind(this);
        this.editUnresolvedname = this.editUnresolvedname.bind(this);
        this.deleteUnresolvedname = this.deleteUnresolvedname.bind(this);
    }

    deleteUnresolvedname(id){
        UnresolvednameService.deleteUnresolvedname(id).then( res => {
            this.setState({unresolvednames: this.state.unresolvednames.filter(unresolvedname => unresolvedname.unresolvednameId !== id)});
        });
    }
    viewUnresolvedname(id){
        this.props.history.push(`/view-unresolvedname/${id}`);
    }
    editUnresolvedname(id){
        this.props.history.push(`/add-unresolvedname/${id}`);
    }

    componentDidMount(){
        UnresolvednameService.getUnresolvednames().then((res) => {
            this.setState({ unresolvednames: res.data});
        });
    }

    addUnresolvedname(){
        this.props.history.push('/add-unresolvedname/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">Unresolvedname List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addUnresolvedname}> Add Unresolvedname</button>
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
                                    this.state.unresolvednames.map(
                                        unresolvedname => 
                                        <tr key = {unresolvedname.unresolvednameId}>
                                             <td>
                                                 <button onClick={ () => this.editUnresolvedname(unresolvedname.unresolvednameId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteUnresolvedname(unresolvedname.unresolvednameId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewUnresolvedname(unresolvedname.unresolvednameId)} className="btn btn-info btn-sm">View </button>
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

export default ListUnresolvednameComponent
