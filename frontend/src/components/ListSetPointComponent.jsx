import React, { Component } from 'react'
import SetPointService from '../services/SetPointService'

class ListSetPointComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
                setPoints: []
        }
        this.addSetPoint = this.addSetPoint.bind(this);
        this.editSetPoint = this.editSetPoint.bind(this);
        this.deleteSetPoint = this.deleteSetPoint.bind(this);
    }

    deleteSetPoint(id){
        SetPointService.deleteSetPoint(id).then( res => {
            this.setState({setPoints: this.state.setPoints.filter(setPoint => setPoint.setPointId !== id)});
        });
    }
    viewSetPoint(id){
        this.props.history.push(`/view-setPoint/${id}`);
    }
    editSetPoint(id){
        this.props.history.push(`/add-setPoint/${id}`);
    }

    componentDidMount(){
        SetPointService.getSetPoints().then((res) => {
            this.setState({ setPoints: res.data});
        });
    }

    addSetPoint(){
        this.props.history.push('/add-setPoint/_add');
    }

    render() {
        return (
            <div>
                 <h2 className="text-center">SetPoint List</h2>
                 <div className = "row">
                    <button className="btn btn-primary btn-sm" onClick={this.addSetPoint}> Add SetPoint</button>
                 </div>
                 <br></br>
                 <div className = "row">
                        <table className = "table table-striped table-bordered">

                            <thead>
                                <tr>
                                    <th> NormalValue </th>
                                    <th> Value </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                {
                                    this.state.setPoints.map(
                                        setPoint => 
                                        <tr key = {setPoint.setPointId}>
                                             <td> { setPoint.normalValue } </td>
                                             <td> { setPoint.value } </td>
                                             <td>
                                                 <button onClick={ () => this.editSetPoint(setPoint.setPointId)} className="btn btn-info btn-sm">Update </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteSetPoint(setPoint.setPointId)} className="btn btn-danger btn-sm">Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.viewSetPoint(setPoint.setPointId)} className="btn btn-info btn-sm">View </button>
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

export default ListSetPointComponent
