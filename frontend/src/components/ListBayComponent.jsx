import React, { Component } from 'react'
import BayService from '../services/BayService'

class ListBayComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                bays: []
        }
        this.addBay = this.addBay.bind(this);
        this.editBay = this.editBay.bind(this);
        this.deleteBay = this.deleteBay.bind(this);
    }

    deleteBay(id){
        BayService.deleteBay(id).then( res => {
            this.setState({bays: this.state.bays.filter(bay => bay.bayId !== id)});
        });
    }
    viewBay(id){
        this.props.history.push(`/view-bay/${id}`);
    }
    editBay(id){
        this.props.history.push(`/add-bay/${id}`);
    }

    componentDidMount(){
        BayService.getBays().then((res) => {
            this.setState({ bays: res.data});
        });
    }

    addBay(){
        this.props.history.push('/add-bay/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">Bay List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addBay}> Add Bay</button>
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
                                    this.state.bays.map(
                                        bay => 
                                        <tr key = {bay.bayId}>
                                             <td>
                                                 <button onClick={ () => this.editBay(bay.bayId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteBay(bay.bayId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewBay(bay.bayId)} className="btn btn-info btn-sm">View </button>
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

export default ListBayComponent
