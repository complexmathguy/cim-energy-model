import React, { Component } from 'react'
import PUService from '../services/PUService'

class ListPUComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                pUs: []
        }
        this.addPU = this.addPU.bind(this);
        this.editPU = this.editPU.bind(this);
        this.deletePU = this.deletePU.bind(this);
    }

    deletePU(id){
        PUService.deletePU(id).then( res => {
            this.setState({pUs: this.state.pUs.filter(pU => pU.pUId !== id)});
        });
    }
    viewPU(id){
        this.props.history.push(`/view-pU/${id}`);
    }
    editPU(id){
        this.props.history.push(`/add-pU/${id}`);
    }

    componentDidMount(){
        PUService.getPUs().then((res) => {
            this.setState({ pUs: res.data});
        });
    }

    addPU(){
        this.props.history.push('/add-pU/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">PU List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addPU}> Add PU</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Multiplier </th>
                                    <th> Unit </th>
                                    <th> Value </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.pUs.map(
                                        pU => 
                                        <tr key = {pU.pUId}>
                                             <td> { pU.multiplier } </td>
                                             <td> { pU.unit } </td>
                                             <td> { pU.value } </td>
                                             <td>
                                                 <button onClick={ () => this.editPU(pU.pUId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deletePU(pU.pUId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewPU(pU.pUId)} className="btn btn-info btn-sm">View </button>
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

export default ListPUComponent
