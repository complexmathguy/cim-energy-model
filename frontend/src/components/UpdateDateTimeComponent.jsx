import React, { Component } from 'react'
import DateTimeService from '../services/DateTimeService';

class UpdateDateTimeComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
        }
        this.updateDateTime = this.updateDateTime.bind(this);

    }

    componentDidMount(){
        DateTimeService.getDateTimeById(this.state.id).then( (res) =>{
            let dateTime = res.data;
            this.setState({
            });
        });
    }

    updateDateTime = (e) => {
        e.preventDefault();
        let dateTime = {
            dateTimeId: this.state.id,
        };
        console.log('dateTime => ' + JSON.stringify(dateTime));
        console.log('id => ' + JSON.stringify(this.state.id));
        DateTimeService.updateDateTime(dateTime).then( res => {
            this.props.history.push('/dateTimes');
        });
    }


    cancel(){
        this.props.history.push('/dateTimes');
    }

    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                <h3 className="text-center">Update DateTime</h3>
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                        </div>
                                        <button className="btn btn-success" onClick={this.updateDateTime}>Save</button>
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

export default UpdateDateTimeComponent
