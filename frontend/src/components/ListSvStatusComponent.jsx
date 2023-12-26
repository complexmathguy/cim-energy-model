import React, { Component } from 'react'
import SvStatusService from '../services/SvStatusService'

class ListSvStatusComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                svStatuss: []
        }
        this.addSvStatus = this.addSvStatus.bind(this);
        this.editSvStatus = this.editSvStatus.bind(this);
        this.deleteSvStatus = this.deleteSvStatus.bind(this);
    }

    deleteSvStatus(id){
        SvStatusService.deleteSvStatus(id).then( res => {
            this.setState({svStatuss: this.state.svStatuss.filter(svStatus => svStatus.svStatusId !== id)});
        });
    }
    viewSvStatus(id){
        this.props.history.push(`/view-svStatus/${id}`);
    }
    editSvStatus(id){
        this.props.history.push(`/add-svStatus/${id}`);
    }

    componentDidMount(){
        SvStatusService.getSvStatuss().then((res) => {
            this.setState({ svStatuss: res.data});
        });
    }

    addSvStatus(){
        this.props.history.push('/add-svStatus/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">SvStatus List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addSvStatus}> Add SvStatus</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> InService </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.svStatuss.map(
                                        svStatus => 
                                        <tr key = {svStatus.svStatusId}>
                                             <td> { svStatus.inService } </td>
                                             <td>
                                                 <button onClick={ () => this.editSvStatus(svStatus.svStatusId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteSvStatus(svStatus.svStatusId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewSvStatus(svStatus.svStatusId)} className="btn btn-info btn-sm">View </button>
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

export default ListSvStatusComponent
