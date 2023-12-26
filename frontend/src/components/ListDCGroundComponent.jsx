import React, { Component } from 'react'
import DCGroundService from '../services/DCGroundService'

class ListDCGroundComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                dCGrounds: []
        }
        this.addDCGround = this.addDCGround.bind(this);
        this.editDCGround = this.editDCGround.bind(this);
        this.deleteDCGround = this.deleteDCGround.bind(this);
    }

    deleteDCGround(id){
        DCGroundService.deleteDCGround(id).then( res => {
            this.setState({dCGrounds: this.state.dCGrounds.filter(dCGround => dCGround.dCGroundId !== id)});
        });
    }
    viewDCGround(id){
        this.props.history.push(`/view-dCGround/${id}`);
    }
    editDCGround(id){
        this.props.history.push(`/add-dCGround/${id}`);
    }

    componentDidMount(){
        DCGroundService.getDCGrounds().then((res) => {
            this.setState({ dCGrounds: res.data});
        });
    }

    addDCGround(){
        this.props.history.push('/add-dCGround/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">DCGround List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addDCGround}> Add DCGround</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> Inductance </th>
                                    <th> R </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.dCGrounds.map(
                                        dCGround => 
                                        <tr key = {dCGround.dCGroundId}>
                                             <td> { dCGround.inductance } </td>
                                             <td> { dCGround.r } </td>
                                             <td>
                                                 <button onClick={ () => this.editDCGround(dCGround.dCGroundId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteDCGround(dCGround.dCGroundId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewDCGround(dCGround.dCGroundId)} className="btn btn-info btn-sm">View </button>
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

export default ListDCGroundComponent
