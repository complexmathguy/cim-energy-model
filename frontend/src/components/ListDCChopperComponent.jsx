import React, { Component } from 'react'
import DCChopperService from '../services/DCChopperService'

class ListDCChopperComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                dCChoppers: []
        }
        this.addDCChopper = this.addDCChopper.bind(this);
        this.editDCChopper = this.editDCChopper.bind(this);
        this.deleteDCChopper = this.deleteDCChopper.bind(this);
    }

    deleteDCChopper(id){
        DCChopperService.deleteDCChopper(id).then( res => {
            this.setState({dCChoppers: this.state.dCChoppers.filter(dCChopper => dCChopper.dCChopperId !== id)});
        });
    }
    viewDCChopper(id){
        this.props.history.push(`/view-dCChopper/${id}`);
    }
    editDCChopper(id){
        this.props.history.push(`/add-dCChopper/${id}`);
    }

    componentDidMount(){
        DCChopperService.getDCChoppers().then((res) => {
            this.setState({ dCChoppers: res.data});
        });
    }

    addDCChopper(){
        this.props.history.push('/add-dCChopper/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">DCChopper List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addDCChopper}> Add DCChopper</button>
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
                                    this.state.dCChoppers.map(
                                        dCChopper => 
                                        <tr key = {dCChopper.dCChopperId}>
                                             <td>
                                                 <button onClick={ () => this.editDCChopper(dCChopper.dCChopperId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteDCChopper(dCChopper.dCChopperId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewDCChopper(dCChopper.dCChopperId)} className="btn btn-info btn-sm">View </button>
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

export default ListDCChopperComponent
