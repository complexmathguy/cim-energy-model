import React, { Component } from 'react'
import RatioTapChangerTablePointService from '../services/RatioTapChangerTablePointService'

class ListRatioTapChangerTablePointComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                ratioTapChangerTablePoints: []
        }
        this.addRatioTapChangerTablePoint = this.addRatioTapChangerTablePoint.bind(this);
        this.editRatioTapChangerTablePoint = this.editRatioTapChangerTablePoint.bind(this);
        this.deleteRatioTapChangerTablePoint = this.deleteRatioTapChangerTablePoint.bind(this);
    }

    deleteRatioTapChangerTablePoint(id){
        RatioTapChangerTablePointService.deleteRatioTapChangerTablePoint(id).then( res => {
            this.setState({ratioTapChangerTablePoints: this.state.ratioTapChangerTablePoints.filter(ratioTapChangerTablePoint => ratioTapChangerTablePoint.ratioTapChangerTablePointId !== id)});
        });
    }
    viewRatioTapChangerTablePoint(id){
        this.props.history.push(`/view-ratioTapChangerTablePoint/${id}`);
    }
    editRatioTapChangerTablePoint(id){
        this.props.history.push(`/add-ratioTapChangerTablePoint/${id}`);
    }

    componentDidMount(){
        RatioTapChangerTablePointService.getRatioTapChangerTablePoints().then((res) => {
            this.setState({ ratioTapChangerTablePoints: res.data});
        });
    }

    addRatioTapChangerTablePoint(){
        this.props.history.push('/add-ratioTapChangerTablePoint/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">RatioTapChangerTablePoint List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addRatioTapChangerTablePoint}> Add RatioTapChangerTablePoint</button>
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
                                    this.state.ratioTapChangerTablePoints.map(
                                        ratioTapChangerTablePoint => 
                                        <tr key = {ratioTapChangerTablePoint.ratioTapChangerTablePointId}>
                                             <td>
                                                 <button onClick={ () => this.editRatioTapChangerTablePoint(ratioTapChangerTablePoint.ratioTapChangerTablePointId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteRatioTapChangerTablePoint(ratioTapChangerTablePoint.ratioTapChangerTablePointId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewRatioTapChangerTablePoint(ratioTapChangerTablePoint.ratioTapChangerTablePointId)} className="btn btn-info btn-sm">View </button>
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

export default ListRatioTapChangerTablePointComponent
