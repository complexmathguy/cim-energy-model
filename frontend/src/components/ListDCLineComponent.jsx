import React, { Component } from 'react'
import DCLineService from '../services/DCLineService'

class ListDCLineComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                dCLines: []
        }
        this.addDCLine = this.addDCLine.bind(this);
        this.editDCLine = this.editDCLine.bind(this);
        this.deleteDCLine = this.deleteDCLine.bind(this);
    }

    deleteDCLine(id){
        DCLineService.deleteDCLine(id).then( res => {
            this.setState({dCLines: this.state.dCLines.filter(dCLine => dCLine.dCLineId !== id)});
        });
    }
    viewDCLine(id){
        this.props.history.push(`/view-dCLine/${id}`);
    }
    editDCLine(id){
        this.props.history.push(`/add-dCLine/${id}`);
    }

    componentDidMount(){
        DCLineService.getDCLines().then((res) => {
            this.setState({ dCLines: res.data});
        });
    }

    addDCLine(){
        this.props.history.push('/add-dCLine/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">DCLine List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addDCLine}> Add DCLine</button>
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
                                    this.state.dCLines.map(
                                        dCLine => 
                                        <tr key = {dCLine.dCLineId}>
                                             <td>
                                                 <button onClick={ () => this.editDCLine(dCLine.dCLineId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteDCLine(dCLine.dCLineId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewDCLine(dCLine.dCLineId)} className="btn btn-info btn-sm">View </button>
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

export default ListDCLineComponent
