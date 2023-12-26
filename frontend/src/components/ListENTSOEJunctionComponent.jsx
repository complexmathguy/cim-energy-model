import React, { Component } from 'react'
import ENTSOEJunctionService from '../services/ENTSOEJunctionService'

class ListENTSOEJunctionComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                eNTSOEJunctions: []
        }
        this.addENTSOEJunction = this.addENTSOEJunction.bind(this);
        this.editENTSOEJunction = this.editENTSOEJunction.bind(this);
        this.deleteENTSOEJunction = this.deleteENTSOEJunction.bind(this);
    }

    deleteENTSOEJunction(id){
        ENTSOEJunctionService.deleteENTSOEJunction(id).then( res => {
            this.setState({eNTSOEJunctions: this.state.eNTSOEJunctions.filter(eNTSOEJunction => eNTSOEJunction.eNTSOEJunctionId !== id)});
        });
    }
    viewENTSOEJunction(id){
        this.props.history.push(`/view-eNTSOEJunction/${id}`);
    }
    editENTSOEJunction(id){
        this.props.history.push(`/add-eNTSOEJunction/${id}`);
    }

    componentDidMount(){
        ENTSOEJunctionService.getENTSOEJunctions().then((res) => {
            this.setState({ eNTSOEJunctions: res.data});
        });
    }

    addENTSOEJunction(){
        this.props.history.push('/add-eNTSOEJunction/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">ENTSOEJunction List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addENTSOEJunction}> Add ENTSOEJunction</button>
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
                                    this.state.eNTSOEJunctions.map(
                                        eNTSOEJunction => 
                                        <tr key = {eNTSOEJunction.eNTSOEJunctionId}>
                                             <td>
                                                 <button onClick={ () => this.editENTSOEJunction(eNTSOEJunction.eNTSOEJunctionId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteENTSOEJunction(eNTSOEJunction.eNTSOEJunctionId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewENTSOEJunction(eNTSOEJunction.eNTSOEJunctionId)} className="btn btn-info btn-sm">View </button>
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

export default ListENTSOEJunctionComponent
