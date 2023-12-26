import React, { Component } from 'react'
import RatioTapChangerTablePointService from '../services/RatioTapChangerTablePointService';

class UpdateRatioTapChangerTablePointComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateRatioTapChangerTablePoint = this.updateRatioTapChangerTablePoint.bind(this);

    }

    componentDidMount(){
        RatioTapChangerTablePointService.getRatioTapChangerTablePointById(this.state.id).then( (res) =>{
            let ratioTapChangerTablePoint = res.data;
            this.setState({
            });
        });
    }

    updateRatioTapChangerTablePoint = (e) => {
        e.preventDefault();
        let ratioTapChangerTablePoint = {
            ratioTapChangerTablePointId: this.state.id,
        };
        console.log('ratioTapChangerTablePoint => ' + JSON.stringify(ratioTapChangerTablePoint));
        console.log('id => ' + JSON.stringify(this.state.id));
        RatioTapChangerTablePointService.updateRatioTapChangerTablePoint(ratioTapChangerTablePoint).then( res => {
            this.props.history.push('/ratioTapChangerTablePoints');
        });
    }


    cancel(){
        this.props.history.push('/ratioTapChangerTablePoints');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update RatioTapChangerTablePoint</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateRatioTapChangerTablePoint}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}

export default UpdateRatioTapChangerTablePointComponent
