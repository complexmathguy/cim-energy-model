import React, { Component } from 'react'
import DCBusbarService from '../services/DCBusbarService'

class ListDCBusbarComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                dCBusbars: []
        }
        this.addDCBusbar = this.addDCBusbar.bind(this);
        this.editDCBusbar = this.editDCBusbar.bind(this);
        this.deleteDCBusbar = this.deleteDCBusbar.bind(this);
    }

    deleteDCBusbar(id){
        DCBusbarService.deleteDCBusbar(id).then( res => {
            this.setState({dCBusbars: this.state.dCBusbars.filter(dCBusbar => dCBusbar.dCBusbarId !== id)});
        });
    }
    viewDCBusbar(id){
        this.props.history.push(`/view-dCBusbar/${id}`);
    }
    editDCBusbar(id){
        this.props.history.push(`/add-dCBusbar/${id}`);
    }

    componentDidMount(){
        DCBusbarService.getDCBusbars().then((res) => {
            this.setState({ dCBusbars: res.data});
        });
    }

    addDCBusbar(){
        this.props.history.push('/add-dCBusbar/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">DCBusbar List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addDCBusbar}> Add DCBusbar</button>
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
                                    this.state.dCBusbars.map(
                                        dCBusbar => 
                                        <tr key = {dCBusbar.dCBusbarId}>
                                             <td>
                                                 <button onClick={ () => this.editDCBusbar(dCBusbar.dCBusbarId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteDCBusbar(dCBusbar.dCBusbarId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewDCBusbar(dCBusbar.dCBusbarId)} className="btn btn-info btn-sm">View </button>
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

export default ListDCBusbarComponent
