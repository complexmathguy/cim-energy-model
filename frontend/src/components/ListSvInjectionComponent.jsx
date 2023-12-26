import React, { Component } from 'react'
import SvInjectionService from '../services/SvInjectionService'

class ListSvInjectionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                svInjections: []
        }
        this.addSvInjection = this.addSvInjection.bind(this);
        this.editSvInjection = this.editSvInjection.bind(this);
        this.deleteSvInjection = this.deleteSvInjection.bind(this);
    }

    deleteSvInjection(id){
        SvInjectionService.deleteSvInjection(id).then( res => {
            this.setState({svInjections: this.state.svInjections.filter(svInjection => svInjection.svInjectionId !== id)});
        });
    }
    viewSvInjection(id){
        this.props.history.push(`/view-svInjection/${id}`);
    }
    editSvInjection(id){
        this.props.history.push(`/add-svInjection/${id}`);
    }

    componentDidMount(){
        SvInjectionService.getSvInjections().then((res) => {
            this.setState({ svInjections: res.data});
        });
    }

    addSvInjection(){
        this.props.history.push('/add-svInjection/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">SvInjection List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addSvInjection}> Add SvInjection</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> PInjection </th>
                                    <th> QInjection </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.svInjections.map(
                                        svInjection => 
                                        <tr key = {svInjection.svInjectionId}>
                                             <td> { svInjection.pInjection } </td>
                                             <td> { svInjection.qInjection } </td>
                                             <td>
                                                 <button onClick={ () => this.editSvInjection(svInjection.svInjectionId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteSvInjection(svInjection.svInjectionId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewSvInjection(svInjection.svInjectionId)} className="btn btn-info btn-sm">View </button>
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

export default ListSvInjectionComponent
